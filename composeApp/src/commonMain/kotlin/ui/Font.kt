@file:OptIn(ExperimentalResourceApi::class)

package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.extra_bold
import eventhubapplication.composeapp.generated.resources.light
import eventhubapplication.composeapp.generated.resources.regular
import eventhubapplication.composeapp.generated.resources.semibold
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@Composable
fun FontBold(): FontFamily {
    return FontFamily(Font(Res.font.extra_bold))
}

@Composable
fun FontRegular(): FontFamily {
    return FontFamily(Font(Res.font.regular))
}

@Composable
fun FontSemiBold(): FontFamily {
    return FontFamily(Font(Res.font.semibold))
}

@Composable
fun FontLight(): FontFamily {
    return FontFamily(Font(Res.font.light))
}

@Composable
fun FontExtraLight(): FontFamily {
    return FontFamily(Font(Res.font.light))
}