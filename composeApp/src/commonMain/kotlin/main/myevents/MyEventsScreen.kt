package main.myevents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.vega.domain.model.my_events.MyEvent
import main.eventdetails.EventDetailsScreen
import org.koin.compose.koinInject
import ui.ColorGreen
import ui.ColorRed
import ui.ColorWhite
import util.Loader

class MyEventsScreen(
    val navigator: Navigator
) : Screen {

    @Composable
    override fun Content() {
        val viewModel: MyEventsViewModel = koinInject()
        when (val state = viewModel.viewState.value) {
            is MyEventsContract.State.Error -> {
                //todo handle error
            }

            is MyEventsContract.State.Init -> {
                Loader()
            }

            is MyEventsContract.State.Success -> {
                val (pastEvents, activeEvents) =
                    viewModel.splitEvents(state.myEventListScreenModel.myEvents)
                ShowMainContent(
                    viewModel = viewModel,
                    activeEvents = activeEvents,
                    pastEvents = pastEvents
                )
            }
        }

        LaunchedEffect(Unit) {
            viewModel.handleEvents(MyEventsContract.Event.ShowMyEvents(0, 10))
            viewModel.effect.collect { effect ->
                when (effect) {
                    //todo, show bottom sheet
                    is MyEventsContract.Effect.NavigateToMyEventDetailsScreen -> {
                        navigator.push(
                            EventDetailsScreen(id = effect.eventId)
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun ShowMainContent(
        viewModel: MyEventsViewModel,
        activeEvents: List<MyEvent>,
        pastEvents: List<MyEvent>
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentPadding = PaddingValues(
                bottom = 16.dp
            )
        ) {
            item {
                MyEventList(
                    events = activeEvents,
                    title = "Active Events",
                    isPastEvent = false
                ) {
                    viewModel.handleEvents(MyEventsContract.Event.SelectMyEventItem(it))
                }

                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                )

                MyEventList(
                    events = pastEvents,
                    title = "Past Events",
                    isPastEvent = true
                ) {
                    viewModel.handleEvents(MyEventsContract.Event.SelectMyEventItem(it))
                }
            }
        }
    }
}