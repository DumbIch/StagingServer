package com.dumdumbich.stsrv.server.ui.root

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
 * @date  24.03.2023 08:28
 */

@Resource("/")
@Serializable
class RootPageRoute

fun Route.rootPageRoute() {
    get<RootPageRoute> {
        call.respondRedirect("/home", permanent = true)
    }
}

fun Application.registerRootPageRoute() {
    routing {
        static("/static") {
            resources("files")
        }
        rootPageRoute()
    }
}