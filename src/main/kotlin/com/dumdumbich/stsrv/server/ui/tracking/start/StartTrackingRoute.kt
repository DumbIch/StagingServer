package com.dumdumbich.stsrv.server.ui.tracking.start

import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023 14:33
 */

@Resource("/tracking/start")
@Serializable
class StartTrackingRoute

fun Route.startTrackingRoute() {
    get<StartTrackingRoute> {
        call.respondText("Tracking changes in the target directory: start")
        //StartTrackingUseCase()
    }
}

fun Application.registerStartTrackingRoute() {
    routing {
        startTrackingRoute()
    }
}