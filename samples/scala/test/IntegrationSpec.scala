import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

class IntegrationSpec extends PlaySpec with OneServerPerTest with OneBrowserPerTest with HtmlUnitFactory {
  "Application" should {
    "work from within a browser" in {
      go to ("http://localhost:" + port)
      pageSource must include ("This is the title page")
    }
  }
}
