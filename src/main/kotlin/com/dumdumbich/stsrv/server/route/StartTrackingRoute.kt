package com.dumdumbich.stsrv.server.route

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023 14:33
 */
 
fun Route.startTrackingRoute() {
    route("/tracking/start") {
        get {
            call.respondText("Tracking changes in the target directory: start")
        }
    }
}

fun Application.registerStartTrackingRoute(){
    routing {
        startTrackingRoute()
    }
}