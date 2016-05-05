package controllers

import javax.inject._

import play.api._
import play.api.mvc._
import play.api.i18n._

@Singleton
class HomeController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {
  def index = Action {
    Ok(views.html.index(messagesApi("index.welcome", "marcos")))
  }
}
