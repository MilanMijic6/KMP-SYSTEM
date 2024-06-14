import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asSkiaBitmap
import org.jetbrains.skia.EncodedImageFormat
import org.jetbrains.skia.Image
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
actual fun convertBitmapToString(imageBitmap: ImageBitmap?): String {
    if (imageBitmap == null) return ""
    val encodedBytes = Image.makeFromBitmap(imageBitmap.asSkiaBitmap()).encodeToData(
        EncodedImageFormat.PNG, 100)?.bytes
    return Base64.Default.encode(encodedBytes!!)
}