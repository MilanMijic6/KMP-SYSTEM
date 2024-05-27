import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
actual fun convertImageToBitmap(icon: String?, sizeWidth: Int, sizeHeight: Int): ImageBitmap {
    if (icon == null) return ImageBitmap(width = sizeWidth, height = sizeHeight)
    val encodedImageData = Base64.Default.decode(icon)
    return BitmapFactory.decodeByteArray(encodedImageData, 0, encodedImageData.size).asImageBitmap()
}