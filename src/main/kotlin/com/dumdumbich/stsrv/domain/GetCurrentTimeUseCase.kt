package com.dumdumbich.stsrv.domain

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  16.03.2023 11:37
 */

class GetCurrentTimeUseCase(
    private val dateTime: DateTimeDataSource
) {
    operator fun invoke(): String = dateTime.timestamp()
}