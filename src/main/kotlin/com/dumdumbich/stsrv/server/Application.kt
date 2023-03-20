package com.dumdumbich.stsrv.server

import com.dumdumbich.stsrv.server.module.monitorModule
import com.dumdumbich.stsrv.server.plugins.ApplicationMonitoringPlugin
import com.dumdumbich.stsrv.server.route.registerHomePageRoute
import com.dumdumbich.stsrv.server.route.registerStartTrackingRoute
import com.dumdumbich.stsrv.server.route.registerStopTrackingRoute
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.*

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023
 */
fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(Resources)
    install(ApplicationMonitoringPlugin)
    monitorModule()
    registerHomePageRoute()
    registerStartTrackingRoute()
    registerStopTrackingRoute()
}
