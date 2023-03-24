package com.dumdumbich.stsrv.server.ui.tracking.stop

import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
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
class StopTrackingPageRoute

fun Route.stopTrackingPageRoute() {
    get<StopTrackingPageRoute> {
        val model = StopTrackingPageModel("Stop tracking")
        call.respond(FreeMarkerContent("stop_tracking_template.ftl", mapOf("model" to model)))
    }
}

fun Application.registerStopTrackingPageRoute() {
    routing {
        stopTrackingPageRoute()
    }
}