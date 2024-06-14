import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import kotlinx.coroutines.CoroutineStart
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
actual fun convertImageToBitmap(icon: String?, sizeWidth: Int, sizeHeight: Int): ImageBitmap? {
    return if (icon.isNullOrEmpty()) {
        null
    } else {
        try {
            val temp = icon.replace("\n", "")
            val imageBytes = Base64.decode(temp)
            val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            bitmap.asImageBitmap()
        } catch (e: Exception) {
            null
        }
    }
}