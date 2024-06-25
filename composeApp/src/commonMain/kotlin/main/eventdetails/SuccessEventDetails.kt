package main.eventdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vega.domain.model.event_details.EventDetails
import convertBase64ToBitmap
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_event_location
import eventhubapplication.composeapp.generated.resources.ic_tab_calendar
import ui.ColorWhite
import ui.FontBold
import ui.FontRegular
import util.PurpleButton

@Composable
fun SuccessEventDetails(
    viewModel: EventDetailsViewModel,
    event: EventDetails,
    handleEvent: (EventDetailsContract.Event) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = ColorWhite
            )
    ) {
        Header(
            id = event.id,
            title = "Event details",
            handleEvent = handleEvent,
            isCreator = viewModel.viewState.value.eventDetailsModel.isUserCreator
        ) {
            handleEvent(
                EventDetailsContract.Event.ClickBackButton
            )
        }

        convertBase64ToBitmap(event.image)?.let {
            Image(
                bitmap = it,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(246.dp)
            )
        }

        Text(
            text = event.name,
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 16.dp
                ),
            color = Color.Black,
            fontSize = 30.sp,
            fontFamily = FontRegular()
        )

        DetailRowItem(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            iconResId = Res.drawable.ic_tab_calendar,
            topText = event.startDate,
            bottomText = event.startTime
        )

        Spacer(modifier = Modifier.height(10.dp))

        DetailRowItem(
            modifier = Modifier.padding(
                horizontal = 16.dp
            ),
            iconResId = Res.drawable.ic_event_location,
            topText = event.place,
            bottomText = event.address
        )

        Text(
            text = "About Event",
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            color = Color.Black,
            fontSize = 18.sp,
            fontFamily = FontBold()
        )

        Text(
            text = event.description,
            modifier = Modifier
                .padding(
                    bottom = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            color = Color.Black,
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontFamily = FontRegular()
        )

        PurpleButton(
            text = "Reserve",
            modifier = Modifier
                .padding(
                    16.dp
                )
        ) {
            handleEvent(
                EventDetailsContract.Event.ClickOnReserveButton
            )
        }
    }
}