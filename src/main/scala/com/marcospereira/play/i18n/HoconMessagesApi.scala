package com.marcospereira.play.i18n

import java.net.URL
import java.util.Properties
import javax.inject.{ Inject, Singleton }

import com.typesafe.config.ConfigFactory
import play.api.i18n._
import play.api.inject.Module
import play.api.{ Configuration, Environment }
import play.utils.Resources

import scala.collection.JavaConverters._

@Singleton
class HoconMessagesApi @Inject() (
    environment: Environment,
    configuration: Configuration,
    langs: Langs
) extends DefaultMessagesApi(environment, configuration, langs) {

  override protected def loadMessages(file: String): Map[String, String] = {
    getResources(file)
      .filterNot(url => Resources.isDirectory(environment.classLoader, url)).reverse
      .map(getMessages)
      .foldLeft(Map.empty[String, String]) { _ ++ _ }
  }

  override protected def loadAllMessages: Map[String, Map[String, String]] = {
    langs.availables.map(_.code).map { lang =>
      (lang, loadMessages(s"messages.$lang.conf"))
    }.toMap ++ Map(
      "default" -> loadMessages("messages.conf"),
      "default.play" -> loadMessages("messages.default")
    )
  }

  private def joinPaths(first: Option[String], second: String) = first match {
    case Some(parent) => new java.io.File(parent, second).getPath
    case None => second
  }

  private def getResources(file: String): List[URL] = {
    environment.classLoader.getResources(joinPaths(messagesPrefix, file)).asScala.toList
  }

  private def getMessages(url: URL): Map[String, String] = {
    // messages.default is bundled with play and it is a properties file
    val config = if (url.toString.endsWith("messages.default")) {
      ConfigFactory.parseProperties(getProperties(url))
    } else {
      ConfigFactory.parseURL(url)
    }

    config.entrySet().asScala
      .map(e => e.getKey -> String.valueOf(e.getValue.unwrapped()))
      .toMap
  }

  private def getProperties(url: URL): Properties = {
    val properties = new Properties()
    val input = url.openStream()
    try {
      properties.load(input)
    } finally {
      input.close()
    }
    properties
  }
}

class HoconI18nModule extends Module {
  def bindings(environment: Environment, configuration: Configuration) = Seq(
    bind[Langs].to[DefaultLangs],
    bind[MessagesApi].to[HoconMessagesApi]
  )
}

trait HoconI18nComponents {

  def environment: Environment
  def configuration: Configuration

  lazy val messagesApi: MessagesApi = new HoconMessagesApi(environment, configuration, langs)
  lazy val langs: Langs = new DefaultLangs(configuration)
}
