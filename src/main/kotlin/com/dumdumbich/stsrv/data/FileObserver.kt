package com.dumdumbich.stsrv.data

import com.dumdumbich.stsrv.debug.DebugMessage
import org.apache.commons.io.monitor.FileAlterationObserver
import java.nio.file.Path

/**
 * @author  DumDumbIch (dumdumbich@mail.ru)
 * @version 1.0
 * @date  15.03.2023 16:03
 */

class FileObserver(private val path: Path):  DebugMessage {
    private var _observer: FileAlterationObserver? = null
    private val observer = _observer!!
}