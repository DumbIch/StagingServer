package com.dumdumbich.stsrv.data

import com.dumdumbich.stsrv.debug.DebugMessage
import org.apache.commons.io.monitor.FileAlterationListener
import org.apache.commons.io.monitor.FileAlterationObserver
import java.io.File

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  10.03.2023
 */

class FileListener(private val os: FileOsAdapter) : DebugMessage {

    private val listener = object: FileAlterationListener {
        override fun onStart(observer: FileAlterationObserver?) {
            consoleMsg(object {}.javaClass.enclosingMethod.name)
        }

        override fun onDirectoryCreate(directory: File?) {
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            consoleMsg("$directory : ${os.lastModifiedTime(directory)}")
        }

        override fun onDirectoryChange(directory: File?) {
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            consoleMsg("$directory : ${os.lastModifiedTime(directory)}")
        }

        override fun onDirectoryDelete(directory: File?) {
            consoleMsg(object {}.javaClass.enclosingMethod.name)
        }

        override fun onFileCreate(file: File?) {
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            consoleMsg("$file : ${os.lastModifiedTime(file)}")
        }

        override fun onFileChange(file: File?) {
            consoleMsg(object {}.javaClass.enclosingMethod.name)
            consoleMsg("$file : ${os.lastModifiedTime(file)}")
        }

        override fun onFileDelete(file: File?) {
            consoleMsg(object {}.javaClass.enclosingMethod.name)
        }

        override fun onStop(observer: FileAlterationObserver?) {
            consoleMsg(object {}.javaClass.enclosingMethod.name)
        }

    }


}
