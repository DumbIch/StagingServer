package com.dumdumbich.stsrv.server.ui.tracking.stop

import com.dumdumbich.stsrv.server.domain.entity.Language
import com.dumdumbich.stsrv.server.ui.base.BasePageModel

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  23.03.2023 11:59
 */

class StopTrackingPageModel(language: Language = Language.RU) : BasePageModel(language) {

    val title = StopTrackingPageString.TITLE.get(language)

}
