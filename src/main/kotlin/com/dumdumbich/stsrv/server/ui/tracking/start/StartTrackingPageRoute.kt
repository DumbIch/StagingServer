package com.dumdumbich.stsrv.server.ui.tracking.start

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
 * @date  15.03.2023 14:33
 */

@Resource("/tracking/start")
@Serializable
class StartTrackingPageRoute

fun Route.startTrackingPageRoute() {
    get<StartTrackingPageRoute> {
        val model = StartTrackingPageModel()
        call.respond(FreeMarkerContent("start_tracking_template.ftl", mapOf("model" to model)))

    }
}

fun Application.registerStartTrackingPageRoute() {
    routing {
        startTrackingPageRoute()
    }
}