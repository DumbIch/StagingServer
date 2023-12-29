package com.dumdumbich.stsrv.data

import com.dumdumbich.stsrv.debug.DebugMessage
import com.dumdumbich.stsrv.domain.FileOsDataSource


/**
 * Класс <code>FileOsDataSourceImpl</code> предоставляет возможность работы с файловой операционной системой в соответствии
 * с контрактом <code>FileOsDataSource</code> Взаимодействует с операционной системой через адаптер <code>FileOs</code>,
 * реализующий контракт <code>FileOsAdapter</code>
 *
 * @author DumDumbIch (dumdumbich@mail.ru)
 */

object FileOsDataSourceImpl : FileOsDataSource, DebugMessage {

    private lateinit var adapter: FileOsAdapter


    override fun init(adapter: FileOsAdapter) {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
        this.adapter = adapter

    }

    override fun done() {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
    }

    override suspend fun createDirectory(path: String) {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
        adapter.createDirectory(adapter.stringToPath(path))
    }

    override suspend fun deleteDirectory(path: String) {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
        adapter.deleteDirectory(adapter.stringToPath(path))
    }

    override suspend fun createFile(path: String, type: FileOsDataSource.FileType) {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
        adapter.createFile(adapter.stringToPath(path))
    }

    override suspend fun deleteFile(path: String) {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
        adapter.deleteFile(adapter.stringToPath(path))
    }

    override suspend fun addText(text: String, path: String) {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
        adapter.addTextToFile(text, adapter.stringToPath(path))
    }

    // Надо проверить
    private fun isPathString(path: String): Boolean = path.matches("^[a-zA-Z0-9/.]*$".toRegex())

}