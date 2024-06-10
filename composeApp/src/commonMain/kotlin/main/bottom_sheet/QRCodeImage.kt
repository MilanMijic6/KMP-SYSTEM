package main.bottom_sheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp
import generateQrCode
import ui.ColorWhite

@Composable
fun QrCodeImage(
    text: String,
    size: Int
) {
    val qrCodeImage = generateQrCode(text, size)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = ColorWhite
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = BitmapPainter(qrCodeImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(size.dp)
        )
    }
}