package iron9light.sample.urlparam.snippet

import net.liftweb.sitemap.Menu
import net.liftweb.common.Full
import net.liftweb.util.Helpers._

/**
 * @author il
 * @version 11/3/11 4:39 PM
 */

case class ParamInfo(param: String)

object ParamInfo {
  val menu = Menu.param[ParamInfo]("param", "param", param => Full(ParamInfo(param)), _.param) / "param"
}

class Param(paramInfo: ParamInfo) {
  def render = "*" #> paramInfo.param
}

class Index {
  def render = "li" #> {
    "name1" :: "name No.2" :: "  Name-3  " :: "Name/4" :: Nil map {
      name => {
        val path1 = ParamInfo.menu.calcHref(ParamInfo(name))
        val path2 = "param/" + urlEncode(name)
        "* *" #> <span>
          {name}<a href={path1}>link1</a> <a href={path2}>link2</a>
        </span>
      }
    }
  }
}