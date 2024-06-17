package main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.vega.domain.model.events.UpcomingEvent
import main.eventdetails.EventDetailsScreen
import org.koin.compose.koinInject
import util.Loader

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: UpcomingEventsViewModel = koinInject()
        val navigator = LocalNavigator.currentOrThrow
        when (val state = viewModel.viewState.value) {
            is UpcomingEventsContract.State.Error -> {
                //todo handle error
            }

            is UpcomingEventsContract.State.Init -> {
                Loader()
            }

            is UpcomingEventsContract.State.Success -> {
                SuccessLoaded(
                    viewModel = viewModel,
                    upcomingEvents = state.upcomingEventListScreenModel.upcomingEvents
                )
            }
        }
        LaunchedEffect(Unit) {
            viewModel.handleEvents(UpcomingEventsContract.Event.ShowUpcomingEvents(0, 10))
            viewModel.effect.collect { effect ->
                when (effect) {
                    is UpcomingEventsContract.Effect.NavigateToEventDetailsScreen -> {
                        navigator.push(EventDetailsScreen(
                            id = effect.eventId
                        ))
                    }
                }
            }
        }
    }

    @Composable
    private fun SuccessLoaded(
        viewModel: UpcomingEventsViewModel,
        upcomingEvents: List<UpcomingEvent>
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            GridList(
                upcomingEvents = upcomingEvents
            ) {
                viewModel.handleEvents(UpcomingEventsContract.Event.SelectUpcomingEventItem(it))
            }
        }
    }
}