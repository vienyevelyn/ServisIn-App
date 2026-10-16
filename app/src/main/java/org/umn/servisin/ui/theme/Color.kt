package org.umn.servisin.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val splashScreenLight = Color(0xFFDBECE1)

val splashScreenDark = Color(0xFF57A773)
//gradien kayak layar splash
val splashGradientBrush = Brush.verticalGradient(
    colors = listOf(splashScreenLight, splashScreenDark),
    startY = 0.0f,
    endY = Float.POSITIVE_INFINITY
)

val darkGreen = Color(0xFF157145)
val lightGreen = Color(0xFF57A773)

val mainScreenLight = Color(0xFFF3F8F3)
val mainScreenDark = Color(0xFFC8E2D0)
//gradien screen biasa
val mainGradientBrush = Brush.verticalGradient(
    colors = listOf(mainScreenDark, mainScreenLight),
    startY = 0.0f,
    endY = Float.POSITIVE_INFINITY
)

val darkBlack = Color(0xFF667367)
val lightWhite = Color(0xFFF3F8F3)
