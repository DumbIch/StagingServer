package com.dumdumbich.stsrv.server

import com.dumdumbich.stsrv.server.module.monitorModule
import com.dumdumbich.stsrv.server.plugins.ApplicationMonitoringPlugin
import com.dumdumbich.stsrv.server.ui.tracking.start.registerStartTrackingRoute
import com.dumdumbich.stsrv.server.ui.tracking.stop.registerStopTrackingRoute
import com.dumdumbich.stsrv.server.ui.home.registerHomePageRoute
import com.dumdumbich.stsrv.server.ui.tracking.directory.registerTrackingDirectoryRoute
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.request.*
import io.ktor.server.resources.*


/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023
 */

// Только для отладки -> перенести в Настройки
const val targetDirectory = "/home/dumdumbich/develop/server/temp/"

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Resources)
    install(ApplicationMonitoringPlugin)
    monitorModule()
    registerHomePageRoute()
    registerStartTrackingRoute()
    registerStopTrackingRoute()
    registerTrackingDirectoryRoute(targetDirectory)
}
