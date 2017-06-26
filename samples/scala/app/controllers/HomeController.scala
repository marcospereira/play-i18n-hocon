package controllers

import javax.inject._

import play.api._
import play.api.mvc._
import play.api.i18n._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController with I18nSupport {

  def index = Action { implicit request: RequestHeader =>
    implicit val lang = messagesApi.preferred(request.acceptLanguages).lang
    Ok(views.html.index(messagesApi("index.welcome", "marcos")))
  }

}
