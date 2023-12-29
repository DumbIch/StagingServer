package com.dumdumbich.stsrv.data


import com.dumdumbich.stsrv.debug.DebugMessage
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.time.Instant

/**
 * Класс <code>FileOs</code> Реализует интерфейс <code>FileOsAdapter</code>, который определяет контракт файловой
 * операционной системы для класса источника данных <code>FileOsDataSource</code>
 *
 * @author DumDumbIch (dumdumbich@mail.ru)
 */

object FileOs : FileOsAdapter, DebugMessage {


    override fun stringToPath(path: String): Path = Paths.get(path)

    override fun init() {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
    }

    override fun done() {
        consoleMsg(object {}.javaClass.enclosingMethod.name)
    }

    override fun isFilePath(path: Path): Boolean = Files.isRegularFile(path)

    override fun isDirectoryPath(path: Path): Boolean = Files.isDirectory(path)

    override fun isPathExists(path: Path): Boolean = Files.exists(path)

    override fun createDirectory(path: Path): Boolean =
        try {
            Files.createDirectory(path)
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }

    override fun deleteDirectory(path: Path): Boolean = deletePath(path)

    override fun renameDirectory(fromPath: Path, toPath: Path): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteFile(path: Path): Boolean = deletePath(path)

    override fun renameFile(fromPath: Path, toPath: Path): Boolean {
        TODO("Not yet implemented")
    }

    private fun deletePath(path: Path): Boolean = try {
        Files.delete(path)
        true
    } catch (e: IOException) {
        e.printStackTrace()
        false
    }

    override fun addTextToFile(data: String, path: Path): Boolean = try {
        Files.write(
            path,
            data.toByteArray(),
            StandardOpenOption.APPEND,
            StandardOpenOption.CREATE
        )
        true
    } catch (e: IOException) {
        e.printStackTrace()
        false
    }

    override fun createFile(path: Path): Boolean = try {
        Files.createFile(path)
        true
    } catch (e: IOException) {
        e.printStackTrace()
        false
    }

//    fun openFile(path: Path): Boolean
//    fun closeFile(path: Path): Boolean


    // переработать - вместо Instance реализовать и использовать функцию в классе Clock или Calendar
    override fun lastModifiedTime(file: File?): Instant? = Instant.ofEpochMilli(
        file?.lastModified() ?: 0
    )

}