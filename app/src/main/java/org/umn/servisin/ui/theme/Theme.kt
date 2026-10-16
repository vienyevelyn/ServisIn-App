package org.umn.servisin.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val ServisinColorScheme = lightColorScheme(
    primary = darkGreen,
    onPrimary = lightWhite,
    secondary = lightGreen,
    onSecondary = darkBlack,
    background = lightWhite,
    onBackground = darkBlack,
    surface = lightWhite,
    onSurface = darkBlack
)

@Composable
fun ServisinTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = ServisinColorScheme,
        typography = Typography,
        content = content
    )
}