package com.dumdumbich.stsrv.domain

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023 14:21
 */

class StartTrackingUseCase(
    private val fileOsEventsDataSource: FileOsEventsDataSource
) {
    operator fun invoke() {
        fileOsEventsDataSource.startTracking()
    }
}