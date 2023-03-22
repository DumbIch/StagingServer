package com.dumdumbich.stsrv.server.ui.home

import com.dumdumbich.stsrv.server.ui.base.BasePageString
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023 14:44
 */

@Resource("/home")
@Serializable
class HomePageRoute

fun Route.homePageRoute() {
    get<HomePageRoute> {
        call.respondHtmlTemplate(HomePageLayout()) {
            header {
                +BasePageString.HEADER.content
            }
            content {
                articleTitle {
                    +HomePageString.TITLE.content
                }
                articleText {
                    +HomePageString.TEXT.content
                }
            }
            footer {
                +BasePageString.FOOTER.content
            }
        }
    }
}

fun Application.registerHomePageRoute() {
    routing {
        homePageRoute()
    }
}