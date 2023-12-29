package com.dumdumbich.stsrv.data

import java.io.File
import java.nio.file.Path
import java.time.Instant

/**
 * Интерфейс <code>FileOsAdapter</code> определяет контракт файловой операционной системы
 * для взаимодействия с классом источника данных <code>FileOsDataSource</code>
 *
 * ВНИМАНИЕ:
 * Возможно придется изменить возвращаемый тип с Boolean на собственный тип FileOsResult на основе sealed класса,
 * который позволит отслеживать ошибки и передавать результат выполнения операции вызывающей стороне
 * Я бы даже сказал - очень скоро ПРИДЕТСЯ ))).
 * Но только не вместо, а в дополнение. А потом посмотрим - может и удалю.
 *
 * @author DumDumbIch (dumdumbich@mail.ru)
 */

interface FileOsAdapter {

    enum class FileEvents {
        MONITOR_START,
        MONITOR_STOP,
        DIRECTORY_CREATE,
        DIRECTORY_CHANGE,
        DIRECTORY_DELETE,
        FILE_CREATE,
        FILE_CHANGE,
        FILE_DELETE
    }

    fun init()
    fun done()
    fun stringToPath(path: String): Path
    fun isFilePath(path: Path): Boolean
    fun isDirectoryPath(path: Path): Boolean
    fun isPathExists(path: Path): Boolean
    fun createDirectory(path: Path): Boolean
    fun deleteDirectory(path: Path): Boolean
    fun renameDirectory(fromPath: Path, toPath: Path):Boolean
    fun createFile(path: Path): Boolean
    fun deleteFile(path: Path): Boolean
    fun renameFile(fromPath: Path, toPath: Path):Boolean
    fun addTextToFile(text: String, path: Path): Boolean
    fun lastModifiedTime(file: File?): Instant? // переработать - вместо Instance реализовать и использовать функцию в классе Clock или Calendar

}
