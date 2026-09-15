package com.robinhood.music.utils

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UpdaterTest {
    @Test
    fun comparesFourPartReleaseVersions() {
        assertTrue(Updater.isUpdateAvailable("13.7.0.0", "v13.7.1.0"))
    }
}
