package com.dumdumbich.stsrv.server.route

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023 14:44
 */

fun Route.homePageRoute() {
    route("/home") {
        get {
            call.respondText("Staging Server for tracking changes in the target directory")
        }
    }
}

fun Application.registerHomePageRoute(){
    routing {
        homePageRoute()
    }
}