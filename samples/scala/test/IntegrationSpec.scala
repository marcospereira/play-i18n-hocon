import play.api.test._
import play.api.test.Helpers._

import org.scalatestplus.play._
import org.scalatestplus.play.guice._

class IntegrationSpec extends PlaySpec with GuiceOneServerPerTest with OneBrowserPerTest with HtmlUnitFactory {
  "Application" should {
    "work from within a browser" in {
      go to ("http://localhost:" + port)
      pageSource must include ("This is the title page")
    }
  }
}
