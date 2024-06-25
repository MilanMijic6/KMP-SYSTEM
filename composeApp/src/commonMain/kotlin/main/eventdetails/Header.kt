package main.eventdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_back_arrow
import org.jetbrains.compose.resources.painterResource
import ui.ColorWhite
import ui.FontRegular

@Composable
fun Header(
    id: String,
    title: String,
    isCreator: Boolean = true,
    handleEvent: (EventDetailsContract.Event) -> Unit,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = ColorWhite
            )
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                end = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_back_arrow),
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            Text(
                text = title,
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = FontRegular(),
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 4.dp
                    )
            )
        }
        if (isCreator) {
            Row {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Icon",
                    modifier = Modifier
                        .clickable {
                            handleEvent(
                                EventDetailsContract.Event.ClickOnEditButton(id = id)
                            )
                        }
                )
                Spacer(
                    modifier = Modifier
                        .width(16.dp)
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Icon",
                    modifier = Modifier
                        .clickable {
                            handleEvent(
                                EventDetailsContract.Event.ClickOnDeleteButton(id = id)
                            )
                        }
                )
            }
        }
    }
}