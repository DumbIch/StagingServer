package com.dumdumbich.stsrv.server.domain.entity

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  24.03.2023 08:49
 */

data class FileInfo(
    val name: String,
    val size: String,
    val createdTime: String,
    val lastModifiedTime: String,
    val mimeType: String,
    val pathType: PathType
) {

    companion object {
        fun empty() = FileInfo("", "1000", "", "", "", PathType.FILE)
    }

}
