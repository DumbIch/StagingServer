package com.dumdumbich.stsrv.server.ui.home

import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
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
        val model = HomePageModel()
        call.respond(FreeMarkerContent("home_template.ftl", mapOf("model" to model)))
    }
}

fun Application.registerHomePageRoute() {
    routing {
        homePageRoute()
    }
}