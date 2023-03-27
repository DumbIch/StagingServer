package com.dumdumbich.stsrv.server.ui.tracking.stop

import com.dumdumbich.stsrv.server.domain.entity.Content
import com.dumdumbich.stsrv.server.domain.entity.Language

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  27.03.2023 14:17
 */

enum class StopTrackingPageString(val content: Content) {

    TITLE(
        Content(
            "Остановка процесса отслеживания",
            "Stop tracking"
        )
    );

    fun get(language: Language): String = when (language) {
        Language.EN -> this.content.en
        Language.RU -> this.content.ru
    }

}