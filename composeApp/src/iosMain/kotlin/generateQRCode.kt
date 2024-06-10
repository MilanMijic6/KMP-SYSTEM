import androidx.compose.ui.graphics.ImageBitmap

actual fun generateQrCode(text: String, size: Int): ImageBitmap {

    return ImageBitmap(
        width = size,
        height = size
    )
}