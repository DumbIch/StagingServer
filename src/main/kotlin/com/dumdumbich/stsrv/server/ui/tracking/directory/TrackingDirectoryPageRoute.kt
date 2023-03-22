package com.dumdumbich.stsrv.server.ui.tracking.directory

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
 * @date  22.03.2023 10:06
 */

@Resource("/tracking/directory")
@Serializable
class TrackingDirectoryRoute


fun Route.trackingDirectoryRoute(directory: String) {
    get<TrackingDirectoryRoute> {
        call.respondHtmlTemplate(TrackingDirectoryPageLayout()) {
            header {
                +BasePageString.HEADER.content
            }
            content {
                articleTitle {
                    +TrackingDirectoryPageString.TITLE.content
                }
                articleText {
                    +TrackingDirectoryPageString.TEXT.content
                }
            }
            footer {
                +BasePageString.FOOTER.content
            }
        }
    }
}

fun Application.registerTrackingDirectoryRoute(directory: String) {
    routing {
        trackingDirectoryRoute(directory)
    }
}
