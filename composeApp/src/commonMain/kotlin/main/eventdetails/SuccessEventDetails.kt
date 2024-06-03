package main.eventdetails

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vega.domain.model.events.UpcomingEvent
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.event_image
import eventhubapplication.composeapp.generated.resources.ic_event_location
import eventhubapplication.composeapp.generated.resources.ic_tab_calendar
import eventhubapplication.composeapp.generated.resources.log_in
import main.home.UpcomingEventsViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import ui.FontBold
import ui.FontRegular
import util.PurpleButton

@Composable
fun SuccessEventDetails(
    viewModel: UpcomingEventsViewModel,
    upcomingEvents: List<UpcomingEvent>
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                //todo use real image later on
                painter = painterResource(Res.drawable.event_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            )

            //todo use real title later on
            Text(
                text = "Internation Band Music Concert",
                modifier = Modifier
                    .padding(
                        vertical = 8.dp,
                        horizontal = 16.dp
                    ),
                color = Color.Black,
                fontSize = 30.sp,
                fontFamily = FontRegular()
            )

            //todo user real data
            DetailRowItem(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp
                    ),
                iconResId = Res.drawable.ic_tab_calendar,
                topText = "14 December, 2021",
                bottomText = "Tuesday, 4:00PM - 9:00PM"
            )

            Spacer(modifier = Modifier.height(10.dp))

            //todo user real data
            DetailRowItem(
                modifier = Modifier.padding(
                    horizontal = 16.dp
                ),
                iconResId = Res.drawable.ic_event_location,
                topText = "Gala Convention Center",
                bottomText = "36 Guild Street London, UK"
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
                text = "Enjoy in  great event and show! Have a nice day!",
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
                text = stringResource(Res.string.log_in),
                modifier = Modifier
                    .padding(
                        16.dp
                    )
            ) {
                /*handleEvent(
                LoginContract.Event.LoginUserEvent
            )*/
            }
        }
        Header(
            title = "Event details"
        ) {
            //todo implement back
        }
    }
}