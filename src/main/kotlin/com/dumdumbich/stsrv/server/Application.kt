package com.dumdumbich.stsrv.server

import com.dumdumbich.stsrv.server.route.registerHomePageRoute
import com.dumdumbich.stsrv.server.route.registerStartTrackingRoute
import com.dumdumbich.stsrv.server.route.registerStopTrackingRoute
import io.ktor.server.application.*

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023
 */

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    registerHomePageRoute()
    registerStartTrackingRoute()
    registerStopTrackingRoute()
}
