package com.dumdumbich.stsrv.server.ui.tracking.start

import com.dumdumbich.stsrv.server.domain.entity.Content
import com.dumdumbich.stsrv.server.domain.entity.Language

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  27.03.2023 14:18
 */

enum class StartTrackingPageString(val content: Content) {

    TITLE(
        Content(
            "Запуск процесса отслеживания",
            "Start tracking"
        )
    );

    fun get(language: Language): String = when (language) {
        Language.EN -> this.content.en
        Language.RU -> this.content.ru
    }

}