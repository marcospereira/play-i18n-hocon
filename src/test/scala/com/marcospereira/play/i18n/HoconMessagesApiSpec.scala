package com.marcospereira.play.i18n

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.i18n.{ I18nModule, Lang, MessagesApi }
import play.api.inject.guice.GuiceApplicationBuilder

class HoconMessagesApiSpec extends PlaySpec with GuiceOneAppPerSuite {

  lazy val lang_en = Lang("en")
  lazy val lang_pt = Lang("pt")
  lazy val lang_pt_br = Lang("pt", "BR")

  implicit override lazy val app = new GuiceApplicationBuilder()
    .configure(Map("play.i18n.langs" -> Seq("en", "pt", "pt-BR")))
    .bindings(new HoconI18nModule)
    .disable(classOf[I18nModule])
    .build()

  "Hocon Messages API" must {

    "load messages from hocon files" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]

      implicit val lang = lang_en

      messagesApi("test.messages.simple") mustBe "Hello"
      messagesApi("test.messages.parameters", "Stranger") mustBe "Hello, Stranger"
    }

    "get messages using the preferred language" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]
      val messages = messagesApi.preferred(Seq(Lang("pt")))

      implicit val lang = lang_pt

      messages("test.messages.simple") mustBe "Ola"
      messages("test.messages.parameters", "Stranger") mustBe "Ola, Stranger"
    }

    "get default language when preferred language is not recognized" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]
      val messages = messagesApi.preferred(Seq(Lang("fr")))

      implicit val lang = Lang("fr")

      messages("test.messages.simple") mustBe "Hello"
      messages("test.messages.parameters", "Stranger") mustBe "Hello, Stranger"
    }

    "get the key itself when message key does not exists" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]

      implicit val lang = lang_en

      messagesApi("test.messages.nonExistent") mustBe "test.messages.nonExistent"
    }

    "get None when translating key does not exists" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]
      messagesApi.preferred(Seq(Lang("en")))

      implicit val lang = lang_en

      messagesApi.translate("test.messages.nonExistent", Seq.empty).isEmpty mustBe true
    }

    "get translation from default messages when key is missing for preferred language" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]

      implicit val lang = lang_en

      messagesApi("test.missing") mustBe "Ok at the default file"
    }

    "get translation for the preferred region" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]
      val messages = messagesApi.preferred(Seq(Lang("pt", "BR")))

      implicit val lang = lang_pt_br

      messages("test.messages.simple") mustBe "Oi"
      messages("test.messages.parameters", "Estranho") mustBe "Oi, Estranho"
    }

    "get translation for language when region is missing" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]

      implicit val lang = Lang("en", "UK")

      messagesApi.preferred(Seq(Lang("en", "UK")))
      messagesApi("test.messages.simple") mustBe "Hello"
    }

    "get default play messages" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]

      implicit val lang = lang_en

      messagesApi("constraint.required") mustBe "Required"
    }

    "get resolved messages" in {
      val messagesApi = app.injector.instanceOf[MessagesApi]
      messagesApi.preferred(Seq(Lang("en")))

      implicit val lang = lang_en

      messagesApi("test.resolve") mustBe "Hello"
    }
  }
}
