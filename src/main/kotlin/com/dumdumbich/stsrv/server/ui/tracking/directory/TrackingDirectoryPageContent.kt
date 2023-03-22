package com.dumdumbich.stsrv.server.ui.tracking.directory

import io.ktor.server.html.*
import kotlinx.html.FlowContent
import kotlinx.html.article
import kotlinx.html.h2
import kotlinx.html.p

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  22.03.2023 10:04
 */

class TrackingDirectoryPageContent  : Template<FlowContent> {
    val articleTitle = Placeholder<FlowContent>()
    val articleText = Placeholder<FlowContent>()
    override fun FlowContent.apply() {
        article {
            h2 {
                insert(articleTitle)
            }
            p {
                insert(articleText)
            }
        }
    }
}