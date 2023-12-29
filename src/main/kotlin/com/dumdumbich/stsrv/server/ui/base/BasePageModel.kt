package com.dumdumbich.stsrv.server.ui.base

import com.dumdumbich.stsrv.server.domain.entity.Language

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  27.03.2023 11:42
 */

open class BasePageModel(language: Language = Language.RU) {

    val titleHeader: String = BasePageString.HEADER.get(language)
    val titleFooter: String = BasePageString.FOOTER.get(language)

    private var _currentLanguage: Language
    val currentLanguage: Language
        get() = _currentLanguage

    init {
        _currentLanguage = language
    }

}