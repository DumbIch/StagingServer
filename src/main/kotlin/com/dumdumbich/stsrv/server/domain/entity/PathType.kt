package com.dumdumbich.stsrv.server.domain.entity

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  27.03.2023 13:42
 */

enum class PathType(val content: Content) {
    FILE(
        Content(
            "Файл",
            "File"
        )
    ),
    DIRECTORY(
        Content(
            "Каталог",
            "Directory"
        )
    );

    fun get(language: Language): String = when (language) {
        Language.EN -> this.content.en
        Language.RU -> this.content.ru
    }

}