package com.dumdumbich.stsrv.server.module

import com.dumdumbich.stsrv.server.plugins.NotFoundEvent
import io.ktor.server.application.*
import io.ktor.server.request.*

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  16.03.2023 15:38
 */

fun Application.monitorModule(){
    environment.monitor.subscribe(ApplicationStarted) { application ->
        application.environment.log.info("Server is started")
    }
    environment.monitor.subscribe(ApplicationStopped) { application ->
        application.environment.log.info("Server is stopped")
        // Release resources and unsubscribe from events
        application.environment.monitor.unsubscribe(ApplicationStarted) {}
        application.environment.monitor.unsubscribe(ApplicationStopped) {}
    }
    environment.monitor.subscribe(NotFoundEvent) { call ->
        log.info("No page was found for the URI: ${call.request.uri}")
    }
}
