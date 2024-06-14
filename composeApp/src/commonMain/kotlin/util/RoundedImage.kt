package util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import convertImageToBitmap
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_placeholder_profile_image
import org.jetbrains.compose.resources.painterResource
import ui.ColorLightGray

@Composable
fun RoundedImage(
    modifier: Modifier = Modifier,
    bitmap: ImageBitmap?,
    icon: String?,
    onClick: () -> Unit = { }
) {
    Box(
        modifier = modifier
            .size(158.dp)
            .clip(CircleShape)
            .border(
                width = 4.dp,
                color = Color.White,
                shape = CircleShape
            )
            .clickable {
                onClick()
            }
    ) {
        val userBitmap = convertImageToBitmap(
            icon = icon,
            sizeHeight = 158,
            sizeWidth = 158
        )
        if (userBitmap != null) {
            Image(
                bitmap = userBitmap,
                contentDescription = "Rounded Image with Border",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(158.dp)
                    .background(Color.White)
            )
        } else if (bitmap != null) {
            Image(
                bitmap = bitmap,
                contentDescription = "Rounded Image with Border",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(158.dp)
                    .background(Color.White)
            )
        } else {
            Image(
                painter = painterResource(Res.drawable.ic_placeholder_profile_image),
                contentDescription = "Placeholder image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(158.dp)
                    .background(ColorLightGray)
                    .padding(30.dp)
            )
        }
    }
}