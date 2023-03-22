package com.dumdumbich.stsrv.server.ui.home

import io.ktor.server.html.*
import kotlinx.html.*

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  22.03.2023 09:01
 */

class HomePageLayout : Template<HTML> {
    val header = Placeholder<FlowContent>()
    val content = TemplatePlaceholder<HomePageContent>()
    val footer = Placeholder<FlowContent>()
    override fun HTML.apply() {
        body {
            h1 {
                insert(header)
            }
            insert(HomePageContent(), content)
            h3 {
                insert(footer)
            }
        }
    }
}