/**
 * RobinHood Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.robinhood.music.models

import com.robinhood.innertube.models.YTItem
import com.robinhood.music.db.entities.LocalItem

data class SimilarRecommendation(
    val title: LocalItem,
    val items: List<YTItem>,
)
