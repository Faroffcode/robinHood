/**
 * RobinHood Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.robinhood.music.ui.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.robinhood.music.BuildConfig
import com.robinhood.music.LocalPlayerAwareWindowInsets
import com.robinhood.music.R

private val RobinHoodGreen = Color(0xFF22E879)
private val RobinHoodDark = Color(0xFF07100C)

@Composable
fun AboutScreen(
    navController: NavController,
) {
    val uriHandler = LocalUriHandler.current
    val windowInsets = LocalPlayerAwareWindowInsets.current
    val scrollState = rememberScrollState()
    val surface = MaterialTheme.colorScheme.surface
    val onSurface = MaterialTheme.colorScheme.onSurface
    val muted = MaterialTheme.colorScheme.onSurfaceVariant
    val cardColor = if (MaterialTheme.colorScheme.isLight) {
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.42f)
    } else {
        RobinHoodDark.copy(alpha = 0.82f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(
                windowInsets.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
            )
            .verticalScroll(scrollState)
            .padding(horizontal = 18.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.small_icon),
            contentDescription = stringResource(R.string.robinhood),
            modifier = Modifier
                .size(104.dp)
                .clip(RoundedCornerShape(28.dp)),
        )

        Spacer(Modifier.height(18.dp))

        Text(
            text = buildAnnotatedString {
                append("Robin")
                withStyle(SpanStyle(color = RobinHoodGreen)) {
                    append("Hood")
                }
            },
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.ExtraBold,
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = "MUSIC FOR EVERYONE",
            style = MaterialTheme.typography.labelMedium,
            color = muted,
            fontWeight = FontWeight.Medium,
            letterSpacing = 4.dp.value.sp,
        )

        Spacer(Modifier.height(22.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = cardColor),
            border = androidx.compose.foundation.BorderStroke(
                1.dp,
                RobinHoodGreen.copy(alpha = 0.16f),
            ),
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 18.dp, vertical = 22.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("About ")
                        withStyle(SpanStyle(color = RobinHoodGreen)) {
                            append("RobinHood")
                        }
                    },
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = "RobinHood is a modern, open music streaming app that lets you search, play, and enjoy millions of songs from YouTube Music — built with a vision of free and accessible music for everyone.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = muted,
                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight,
                    textAlign = TextAlign.Center,
                )

                Spacer(Modifier.height(22.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top,
                ) {
                    AboutFeature("⌕", "Search", "Find your favorite\nsongs easily", onSurface)
                    AboutFeature("▶", "Stream", "High quality\nplayback", onSurface)
                    AboutFeature("♥", "Discover", "Explore new music\nevery day", onSurface)
                    AboutFeature("♣", "For Everyone", "Open, free, and\naccessible", onSurface)
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = cardColor),
            border = androidx.compose.foundation.BorderStroke(
                1.dp,
                RobinHoodGreen.copy(alpha = 0.12f),
            ),
        ) {
            Row(
                modifier = Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(86.dp)
                        .clip(RoundedCornerShape(43.dp))
                        .background(RobinHoodGreen.copy(alpha = 0.08f))
                        .border(
                            2.dp,
                            RobinHoodGreen,
                            RoundedCornerShape(43.dp),
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "Faroff",
                        color = RobinHoodGreen,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(Modifier.width(18.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Developed by",
                        style = MaterialTheme.typography.bodyMedium,
                        color = muted,
                    )
                    Text(
                        text = "Imtiaz Haque (FAROFF)",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Building tools for a more open and accessible internet.",
                        style = MaterialTheme.typography.bodySmall,
                        color = muted,
                    )
                }
            }
        }

        Spacer(Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            AboutLink(
                label = "Website",
                value = "faroffcode.github.io/R-Hood-web",
                modifier = Modifier.weight(1f),
                onClick = { uriHandler.openUri("https://faroffcode.github.io/R-Hood-web/") },
            )
            AboutLink(
                label = "Telegram",
                value = "@robinhoodmusicapp",
                modifier = Modifier.weight(1f),
                onClick = { uriHandler.openUri("https://t.me/robinhoodmusicapp") },
            )
        }

        Spacer(Modifier.height(24.dp))

        Text(
            text = "GOOD MUSIC SHOULD BE FREE",
            style = MaterialTheme.typography.titleSmall,
            color = RobinHoodGreen,
            fontWeight = FontWeight.Bold,
            letterSpacing = 3.dp.value.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "LISTEN  •  DISCOVER  •  BELONG",
            style = MaterialTheme.typography.labelSmall,
            color = muted,
            letterSpacing = 2.dp.value.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Version ${BuildConfig.VERSION_NAME}",
            style = MaterialTheme.typography.labelSmall,
            color = muted,
        )
    }
}

@Composable
private fun AboutFeature(
    icon: String,
    title: String,
    description: String,
    onSurface: Color,
) {
    Column(
        modifier = Modifier.width(70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(RobinHoodGreen.copy(alpha = 0.09f))
                .border(
                    1.dp,
                    RobinHoodGreen.copy(alpha = 0.22f),
                    RoundedCornerShape(16.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = icon,
                color = RobinHoodGreen,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(Modifier.height(8.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = onSurface,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(2.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun AboutLink(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = RobinHoodGreen.copy(alpha = 0.08f),
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            RobinHoodGreen.copy(alpha = 0.18f),
        ),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge,
                color = RobinHoodGreen,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.height(3.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
            )
        }
    }
}
