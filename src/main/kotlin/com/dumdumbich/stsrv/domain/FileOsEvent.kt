package com.dumdumbich.stsrv.domain

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  16.03.2023 09:45
 */

data class FileOsEvent(
    val timestamp: String,
    val eventType: EventType,
    val path: String
) {

    enum class EventType(val description: String) {
        START_TRACKING("Start tracking"),
        STOP_TRACKING("Stop tracking"),
        CREATE_DIRECTORY("Create new directory"),
        CREATE_FILE("Create new file"),
        DELETE_DIRECTORY("Delete directory"),
        DELETE_FILE("Delete file"),
        CHANGE_DIRECTORY("Change directory"),
        CHANGE_FILE("Change file"),
        START_TRACKING_FAIL("Start tracking fail"),
        STOP_TRACKING_FAIL("Stop tracking fail"),
        CREATE_DIRECTORY_FAIL("Create new directory fail"),
        CREATE_FILE_FAIL("Create new file fail"),
        DELETE_DIRECTORY_FAIL("Delete directory fail"),
        DELETE_FILE_FAIL("Delete file fail"),
        CHANGE_DIRECTORY_FAIL("Change directory fail"),
        CHANGE_FILE_FAIL("Change file fail"),
    }

}
