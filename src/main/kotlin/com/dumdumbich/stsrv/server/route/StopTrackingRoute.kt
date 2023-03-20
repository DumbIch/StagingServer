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
 * @date  15.03.2023 14:41
 */

@Resource("/tracking/stop")
@Serializable
class StopTrackingRoute

fun Route.stopTrackingRoute() {
    get<StopTrackingRoute> {
        call.respondText("Tracking changes in the target directory: stop")
    }
}

fun Application.registerStopTrackingRoute() {
    routing {
        stopTrackingRoute()
    }
}