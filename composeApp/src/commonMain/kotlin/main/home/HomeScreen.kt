package main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.vega.domain.model.events.UpcomingEvent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.koinInject
import util.Loader

class HomeScreen() : Screen {

    @Composable
    override fun Content() {
        val viewModel: UpcomingEventsViewModel = koinInject()
        when (val state = viewModel.viewState.value) {
            is UpcomingEventsContract.State.Error -> {
                //todo handle error loading
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
                        //todo handle navigation on click
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun SuccessLoaded(
        viewModel: UpcomingEventsViewModel,
        upcomingEvents: List<UpcomingEvent>
    ) {
        Column(
            modifier = Modifier
                .padding(end = 26.dp)
                .fillMaxHeight()
        ) {
            /*CryptoList(
                cryptoList = upcomingEvents
            ) {
                viewModel.handleEvents(UpcomingEventsContract.Event.SelectUpcomingEventItem(it))
            }*/
        }
    }
}