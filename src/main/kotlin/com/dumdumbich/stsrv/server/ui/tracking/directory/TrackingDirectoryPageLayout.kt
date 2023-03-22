package com.dumdumbich.stsrv.server.ui.tracking.directory

import io.ktor.server.html.*
import kotlinx.html.*

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  22.03.2023 10:05
 */

class TrackingDirectoryPageLayout : Template<HTML> {
    val header = Placeholder<FlowContent>()
    val content = TemplatePlaceholder<TrackingDirectoryPageContent>()
    val footer = Placeholder<FlowContent>()
    override fun HTML.apply() {
        body {
            h1 {
                insert(header)
            }
            insert(TrackingDirectoryPageContent(), content)
            h3 {
                insert(footer)
            }
        }
    }
}