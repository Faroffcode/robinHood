package com.robinhood.innertube.pages

import com.robinhood.innertube.models.SongItem

data class PlaylistContinuationPage(
    val songs: List<SongItem>,
    val continuation: String?,
)
