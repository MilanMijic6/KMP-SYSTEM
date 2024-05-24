package util

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.dummy_profile_image
import org.jetbrains.compose.resources.painterResource

@Composable
fun RoundedImage(
    modifier: Modifier = Modifier
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
    ) {
        Image(
            painter = painterResource(Res.drawable.dummy_profile_image),
            contentDescription = "Rounded Image with Border",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(158.dp)
        )
    }
}