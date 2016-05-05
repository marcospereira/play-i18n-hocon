package controllers;

import javax.inject.Inject;

import play.mvc.*;
import play.i18n.*;

import views.html.*;

public class HomeController extends Controller {

    private MessagesApi messagesApi;

    @Inject
    public HomeController(MessagesApi messagesApi) {
        this.messagesApi = messagesApi;
    }

    public Result index() {
        Lang lang = Http.Context.current().lang();
        return ok(index.render(messagesApi.get(lang, "index.welcome")));
    }

}
