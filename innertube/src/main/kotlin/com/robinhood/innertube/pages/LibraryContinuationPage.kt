package com.robinhood.innertube.pages

import com.robinhood.innertube.models.YTItem

data class LibraryContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
