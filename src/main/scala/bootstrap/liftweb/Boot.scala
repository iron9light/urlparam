package bootstrap.liftweb

import net.liftweb.sitemap.{Menu, SiteMap}
import iron9light.sample.urlparam.snippet.ParamInfo
import net.liftweb.http.{Html5Properties, Req, LiftRules}

/**
 * @author il
 * @version 11/3/11 4:34 PM
 */

class Boot {
  def boot {
    LiftRules.addToPackages("iron9light.sample.urlparam")

    def siteMap() = SiteMap(
      Menu.i("Home") / "index",
      ParamInfo.menu
    )

    LiftRules.setSiteMapFunc(siteMap)

    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))
  }
}