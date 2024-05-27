import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
actual fun convertImageToBitmap(icon: String?, sizeWidth: Int, sizeHeight: Int): ImageBitmap {
    if (icon == null) return ImageBitmap(width = sizeWidth, height = sizeHeight)
    val encodedImageData = Base64.Default.decode(icon)
    return Image.makeFromEncoded(encodedImageData).toComposeImageBitmap()
}