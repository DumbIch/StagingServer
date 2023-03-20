package com.dumdumbich.stsrv.server.route

import io.ktor.resources.*
import io.ktor.server.application.*
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
        call.respondText("Staging Server for tracking changes in the target directory")
    }
}

fun Application.registerHomePageRoute() {
    routing {
        homePageRoute()
    }
}