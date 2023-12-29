package com.dumdumbich.stsrv.server.ui.tracking.directory

import com.dumdumbich.stsrv.server.targetDirectory
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
 * @date  22.03.2023 10:06
 */

@Resource("/tracking/directory")
@Serializable
class TrackingDirectoryPageRoute


fun Route.trackingDirectoryPageRoute(directory: String) {
    get<TrackingDirectoryPageRoute> {
        val model = TrackingDirectoryPageModel(targetDirectory)
        call.respond(FreeMarkerContent("tracking_directory_template.ftl", mapOf("model" to model)))
    }
}

fun Application.registerTrackingDirectoryPageRoute(directory: String) {
    routing {
        trackingDirectoryPageRoute(directory)
    }
}
