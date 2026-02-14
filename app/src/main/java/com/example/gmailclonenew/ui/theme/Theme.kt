package com.example.gmailclonenew.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = GmailRed,
    onPrimary = GmailSurface,
    primaryContainer = GmailRedDark,
    onPrimaryContainer = GmailSurface,
    surface = GmailSurface,
    onSurface = GmailOnSurface,
    surfaceVariant = GmailSurfaceVariant,
    onSurfaceVariant = GmailOnSurfaceVariant,
    background = GmailSurface,
    onBackground = GmailOnSurface
)

@Composable
fun GmailCloneTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}

