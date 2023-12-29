package com.dumdumbich.stsrv.domain

import com.dumdumbich.stsrv.data.FileOsAdapter


/**
 * Интерфейс <code>FileOsUsecase</code> определяет контракт для класса <code>FileOsDataSource</code>, который
 * предоставляет возможность работы с файловой операционной системой
 *
 * @author DumDumbIch (dumdumbich@mail.ru)
 */

interface FileOsDataSource {

    enum class FileType {
        BINARY,
        TEXT,
    }

    fun init(adapter: FileOsAdapter)
    fun done()
    suspend fun createDirectory(path: String)
    suspend fun deleteDirectory(path: String)
    suspend fun createFile(path: String, type: FileType)
    suspend fun deleteFile(path: String)
    suspend fun addText(text: String, path: String)
}
