package main.bottom_sheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vega.domain.model.my_events.MyEvent
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_event_location
import eventhubapplication.composeapp.generated.resources.ic_tab_calendar
import main.eventdetails.DetailRowItem
import ui.FontBold
import ui.FontRegular

@Composable
fun MyEventDetails(
    myEvent: MyEvent
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Victoria Robertson",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 8.dp,
                        horizontal = 80.dp
                    ),
                color = Color.Green,
                fontSize = 30.sp,
                fontFamily = FontBold(),
                maxLines = 2,
                textAlign = TextAlign.Center
            )

            Text(
                text = myEvent.name,
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
                topText = myEvent.dateMonth,
                bottomText = myEvent.dateDay
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            DetailRowItem(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp
                    ),
                iconResId = Res.drawable.ic_event_location,
                topText = myEvent.place,
                bottomText = myEvent.address
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
                text = myEvent.description,
                modifier = Modifier
                    .padding(
                        bottom = 8.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                color = Color.Black,
                fontSize = 16.sp,
                maxLines = 8,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontRegular()
            )
        }
    }
}