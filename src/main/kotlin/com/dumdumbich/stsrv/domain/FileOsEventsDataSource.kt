package com.dumdumbich.stsrv.domain

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  16.03.2023 09:33
 */

interface FileOsEventsDataSource {
    fun startTracking()
    fun stopTracking()
    fun getEvents(): List<FileOsEvent>
}