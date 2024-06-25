package util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_event_location
import org.jetbrains.compose.resources.painterResource
import ui.ColorLightOrange
import ui.ColorOrange
import ui.FontRegular
import ui.TextGray

@Composable
fun EventListItem(
    bitmap: ImageBitmap?,
    labelText: String,
    iconLabelText: String,
    titleColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
    textInBoxFirstLabel: String,
    textInBoxSecondLabel: String,
    itemWidth: Int,
    contentModifier: Modifier = Modifier
) {
    Column(
        modifier = contentModifier
            .padding(8.dp)
            .background(backgroundColor, RoundedCornerShape(18.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            if (bitmap != null) {
                Image(
                    bitmap = bitmap,
                    contentDescription = null,
                    modifier = Modifier
                        .width(itemWidth.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(ColorLightOrange)
                    .padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = textInBoxFirstLabel,
                        fontSize = 18.sp,
                        color = ColorOrange
                    )
                    Text(
                        text = textInBoxSecondLabel,
                        fontSize = 10.sp,
                        color = ColorOrange
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(
                    top = 4.dp,
                    start = 6.dp,
                    end = 6.dp
                )
        ) {
            Text(
                text = labelText,
                fontSize = 18.sp,
                color = titleColor,
                fontFamily = FontRegular(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(
                        top = 30.dp,
                        bottom = 10.dp
                    )
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_event_location),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp),
                    tint = TextGray
                )
                Text(
                    text = iconLabelText,
                    fontSize = 13.sp,
                    color = TextGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}