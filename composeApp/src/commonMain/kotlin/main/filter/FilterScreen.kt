package main.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_event_location
import eventhubapplication.composeapp.generated.resources.ic_tab_calendar
import main.filter.date_time_filter.FilterButtonList
import main.filter.date_time_filter.FilterByDateRow
import main.filter.event_filter.FilterList
import main.filter.price_filter.PriceLabelRow
import main.filter.price_filter.PurpleSlider
import ui.FontRegular
import util.PurpleButton

class FilterScreen: Screen {

    @Composable
    override fun Content() {
        ShowMainContent()
    }

    @Composable
    fun ShowMainContent() {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 20.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Filter",
                    fontFamily = FontRegular(),
                    fontSize = 26.sp,
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            FilterList()

            Text(
                text = "Time & Date",
                fontFamily = FontRegular(),
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 10.dp,
                        start = 16.dp
                    )
            )

            FilterButtonList()

            FilterByDateRow(
                modifier = Modifier
                    .padding(
                        top = 8.dp
                    ),
                text = "Choose from calendar",
                height = 54,
                icon = Res.drawable.ic_tab_calendar
            ) {

            }

            Text(
                text = "Location",
                fontFamily = FontRegular(),
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 10.dp,
                        start = 16.dp
                    )
            )

            FilterByDateRow(
                modifier = Modifier
                    .padding(
                        top = 8.dp
                    ),
                text = "New York, USA",
                height = 54,
                icon = Res.drawable.ic_event_location
            ) {

            }

            PriceLabelRow(
                title = "Select price range",
                priceValueStart = 0,
                priceValueEnd = 120,
                modifier = Modifier
                    .padding(
                        top = 10.dp
                    )
            )

            PurpleSlider(
                minValue = 0f,
                maxValue = 120f,
                slideStep = 10,
                onTextChanged = {

                }
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            PurpleButton(
                text = "APPLY",
                modifier = Modifier
                    .padding(
                        16.dp
                    )
            ) {

            }
        }
    }
}