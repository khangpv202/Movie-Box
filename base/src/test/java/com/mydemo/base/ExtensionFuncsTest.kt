package com.mydemo.base

import org.junit.Assert
import org.junit.Test

/**
 * Created by khangpv.
 * FinOs
 */
class ExtensionFuncTest {
    @Test
    fun testConvertDuration() {
        var runtime = 60
        Assert.assertEquals("1h 0m", runtime.convertDuration())
        runtime = 97
        Assert.assertEquals("1h 37m", runtime.convertDuration())
        runtime = 45
        Assert.assertEquals("45m", runtime.convertDuration())
    }
}