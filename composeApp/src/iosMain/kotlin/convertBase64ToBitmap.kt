import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
actual fun convertBase64ToBitmap(icon: String?): ImageBitmap? {
    if (icon == null) return null
    val temp = icon.replace("\n", "")
    val encodedImageData = Base64.Default.decode(temp)
    return Image.makeFromEncoded(encodedImageData).toComposeImageBitmap()
}