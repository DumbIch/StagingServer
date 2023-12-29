package com.dumdumbich.stsrv.server.domain.usecase

import com.dumdumbich.stsrv.server.domain.entity.FileInfo
import com.dumdumbich.stsrv.server.domain.entity.PathType
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes
import kotlin.io.path.*

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  24.03.2023 08:55
 */

class GetFileInfoUseCase(
    private val pathStr: String
) {

    private val path: Path
        get() = Paths.get(pathStr)

    operator fun invoke(): List<FileInfo> {
        val fileInfoList = mutableListOf<FileInfo>()

        if (Files.exists(path) && path.isDirectory()) {
            Files.walk(path)
//                .filter { Files.isRegularFile((it)) }
                .forEach {
                    val attr = Files.readAttributes<BasicFileAttributes>(path, BasicFileAttributes::class.java)
                    val name = it.fileName.toString()
                    val size = attr.size().toString()
                    val createdTime = attr.creationTime().toString()
                    val lastModifiedTime = attr.lastModifiedTime().toString()
                    val mimeType: String = "plan/text"
                    val pathType = if (it.isDirectory()) PathType.DIRECTORY else PathType.FILE
                    val fileInfo = FileInfo(name, size, createdTime, lastModifiedTime, mimeType, pathType)
                    fileInfoList.add(fileInfo)
                }
        }
        return fileInfoList.toList()
    }

//    private fun getFileInfo(path:Path):FileInfo {
//        val attr = Files.readAttributes<BasicFileAttributes>(path, BasicFileAttributes::class.java)
//        val name = path.fileName.toString()
//        val size = attr.size().toString()
//        val createdTime = attr.creationTime().toString()
//        val lastModifiedTime = attr.lastModifiedTime().toString()
//        val mimeType: String = "plan/text"
//        val pathType = if (path.isDirectory()) PathType.DIRECTORY else PathType.FILE
//        return FileInfo(name, size, createdTime, lastModifiedTime, mimeType, pathType)
//    }

}