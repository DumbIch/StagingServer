package com.dumdumbich.stsrv.data

import com.dumdumbich.stsrv.debug.DebugMessage
import com.dumdumbich.stsrv.domain.FileOsEvent
import com.dumdumbich.stsrv.domain.FileOsEventsDataSource
import com.dumdumbich.stsrv.domain.GetCurrentTimeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.apache.commons.io.monitor.FileAlterationListener
import org.apache.commons.io.monitor.FileAlterationObserver
import java.io.File
import kotlin.coroutines.CoroutineContext

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023 16:04
 */

class FileOsEventsDataSourceImpl(
    private val os: FileOsAdapter,
    path: String,
    getCurrentTime: GetCurrentTimeUseCase,
    private val polling: Long, // Определить тип время и использовать вместо Long
    private val context: CoroutineContext = Dispatchers.IO
) : FileOsEventsDataSource, DebugMessage {

    private var _events = mutableListOf<FileOsEvent>()
//    private val events: List<FileOsEvent>
//        get() = _events

    private var _observer: FileAlterationObserver = FileAlterationObserver(path)

    private val listener = object : FileAlterationListener {

        override fun onStart(observer: FileAlterationObserver?) {
            val timestamp = getCurrentTime()
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            if (observer != null) {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.START_TRACKING,
                        observer.directory.absolutePath
                    )
                )
            } else {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.START_TRACKING_FAIL,
                        _observer.directory.absolutePath
                    )
                )
            }
        }

        override fun onDirectoryCreate(directory: File?) {
            val timestamp = getCurrentTime()
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            consoleMsg("$directory : ${os.lastModifiedTime(directory)}")
            if (directory != null) {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.CREATE_DIRECTORY,
                        directory.absolutePath
                    )
                )
            } else {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.CREATE_DIRECTORY_FAIL,
                        _observer.directory.absolutePath
                    )
                )
            }
        }

        override fun onDirectoryChange(directory: File?) {
            val timestamp = getCurrentTime()
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            consoleMsg("$directory : ${os.lastModifiedTime(directory)}")
            if (directory != null) {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.CHANGE_DIRECTORY,
                        directory.absolutePath
                    )
                )
            } else {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.CHANGE_DIRECTORY_FAIL,
                        _observer.directory.absolutePath
                    )
                )
            }
        }

        override fun onDirectoryDelete(directory: File?) {
            val timestamp = getCurrentTime()
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            if (directory != null) {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.DELETE_DIRECTORY,
                        directory.absolutePath
                    )
                )
            } else {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.DELETE_DIRECTORY_FAIL,
                        _observer.directory.absolutePath
                    )
                )
            }
        }

        override fun onFileCreate(file: File?) {
            val timestamp = getCurrentTime()
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            consoleMsg("$file : ${os.lastModifiedTime(file)}")
            if (file != null) {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.CREATE_FILE,
                        file.absolutePath
                    )
                )
            } else {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.CREATE_FILE_FAIL,
                        _observer.directory.absolutePath
                    )
                )
            }
        }

        override fun onFileChange(file: File?) {
            val timestamp = getCurrentTime()
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            consoleMsg("$file : ${os.lastModifiedTime(file)}")
            if (file != null) {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.CHANGE_FILE,
                        file.absolutePath
                    )
                )
            } else {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.CHANGE_FILE_FAIL,
                        _observer.directory.absolutePath
                    )
                )
            }
        }

        override fun onFileDelete(file: File?) {
            val timestamp = getCurrentTime()
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            if (file != null) {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.DELETE_FILE,
                        file.absolutePath
                    )
                )
            } else {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.DELETE_FILE_FAIL,
                        _observer.directory.absolutePath
                    )
                )
            }
        }

        override fun onStop(observer: FileAlterationObserver?) {
            val timestamp = getCurrentTime()
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            if (observer != null) {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.STOP_TRACKING,
                        observer.directory.absolutePath
                    )
                )
            } else {
                _events.add(
                    FileOsEvent(
                        timestamp,
                        FileOsEvent.EventType.STOP_TRACKING_FAIL,
                        _observer.directory.absolutePath
                    )
                )
            }
        }

    }


    private suspend fun fileOsEventsLoop() {
        withContext(context) {
            if (_observer.listeners.none())
                checkEvents()
            delay(polling)
        }
    }

    private fun checkEvents() {
        if (!(_observer.listeners.none())) {
            _observer.checkAndNotify()
        }
    }

    override fun startTracking() {
        _observer.addListener(listener)
    }

    override fun stopTracking() {
        _observer.removeListener(listener)
    }

    override fun getEvents(): List<FileOsEvent> = _events

}