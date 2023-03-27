package com.dumdumbich.stsrv.server.ui.base

import com.dumdumbich.stsrv.server.domain.entity.Content
import com.dumdumbich.stsrv.server.domain.entity.Language

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  22.03.2023 09:30
 */

enum class BasePageString(val content: Content) {
    HEADER(
        Content(
            "Промежуточный файловый сервер системы регистрации аварийных и переходных процессов",
            "Staging file server of Disturbance recorder system"
        )
    ),
    FOOTER(
        Content(
            "При технической поддержке ДимДимЫч : dumdumbich@mail.ru",
            "with technical support by DumDumbIch : dumdumbich@mail.ru"
        )
    );

    fun get(language: Language): String = when (language) {
        Language.EN -> this.content.en
        Language.RU -> this.content.ru
    }

}