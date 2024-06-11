package main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.profile
import eventhubapplication.composeapp.generated.resources.tab_home
import eventhubapplication.composeapp.generated.resources.tab_my_events
import main.filter.FilterScreen
import main.tabs.HomeTab
import main.tabs.MyEventsTab
import main.tabs.ProfileTab
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import ui.ColorLightGray
import ui.ColorPurple
import ui.ColorPurple75
import util.TabNavigationItem
import util.TopBarActionType
import util.TopBarHeader

class MainScreen(
    private val navigator: Navigator
) : Screen {

    @Composable
    override fun Content() {
        val mainViewModel: MainViewModel = koinInject()

        ShowMainContent(
            navigator = navigator,
            viewModel = mainViewModel
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ShowMainContent(
        navigator: Navigator,
        viewModel: MainViewModel
    ) {
        TabNavigator(HomeTab(navigator)) { tabNavigator ->
            val toolbarActionType: TopBarActionType = getToolbarActionIcon(tabNavigator.current)
            Scaffold(
                topBar = {
                    TopBarHeader(
                        titleColor = getToolbarTitleColor(tabNavigator.current),
                        title = getToolbarTitle(tabNavigator.current),
                        backgroundColor = getToolbarActionColor(tabNavigator.current),
                        navigationActionType = getToolbarActionIcon(tabNavigator.current),
                        isLoggedIn = viewModel.viewState.value.mainScreenModel.isLoggedIn,
                    ) {
                        when (toolbarActionType) {
                            TopBarActionType.MY_EVENTS -> {
                                viewModel.handleEvents(MainContract.Event.ClickOnScanEvent)
                            }
                            TopBarActionType.PROFILE -> {
                                viewModel.handleEvents(MainContract.Event.ClickOnLogoutEvent)
                            }
                            else -> {
                                viewModel.handleEvents(MainContract.Event.ClickOnFilterEvent)
                            }
                        }
                    }
                },
                bottomBar = {
                    populateBottomTabs(
                        navigator = navigator,
                        tabNavigator = tabNavigator,
                        viewModel = viewModel
                    )
                },
                containerColor = ColorLightGray
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            top = it.calculateTopPadding(),
                            bottom = if (tabNavigator.current.options.title == "Home")
                                0.dp else it.calculateBottomPadding()
                        )
                ) {
                    CurrentTab()
                }
            }
        }
    }
}

@Composable
private fun populateBottomTabs(
    navigator: Navigator,
    tabNavigator: TabNavigator,
    viewModel: MainViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                MainContract.Effect.NavigateToAccountScreen -> tabNavigator.current = ProfileTab
                MainContract.Effect.NavigateToFilterScreen -> navigator.push(FilterScreen())
                MainContract.Effect.NavigateToHomeScreen -> tabNavigator.current =
                    HomeTab(navigator)

                MainContract.Effect.NavigateToMyEventsScreen -> tabNavigator.current =
                    MyEventsTab(navigator)

                MainContract.Effect.ShowLoginDialog -> {

                }

                MainContract.Effect.LogoutUser -> {

                }

                MainContract.Effect.NavigateToScanScreen -> {

                }
            }
        }
    }
    BottomNavigation(
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                )
            ),
        backgroundColor = ColorPurple75
    ) {
        TabNavigationItem(
            tab = HomeTab(navigator),
            onSelected = tabNavigator.current.key == HomeTab(navigator).key
        ) {
            viewModel.handleEvents(MainContract.Event.ClickOnHomeEvent)
        }
        TabNavigationItem(
            tab = MyEventsTab(navigator),
            onSelected = tabNavigator.current.key == MyEventsTab(navigator).key
        ) {
            viewModel.handleEvents(MainContract.Event.ClickOnMyEventsEvent)
        }
        TabNavigationItem(
            tab = ProfileTab,
            onSelected = tabNavigator.current.key == ProfileTab.key
        ) {
            viewModel.handleEvents(MainContract.Event.ClickOnAccountEvent)
        }
    }
}

@Composable
private fun getToolbarTitle(tabName: Tab): String {
    return when (tabName.options.title) {
        "Home" -> stringResource(Res.string.tab_home)
        "My events" -> stringResource(Res.string.tab_my_events)
        "Account" -> stringResource(Res.string.profile)
        else -> ""
    }
}

@Composable
private fun getToolbarActionIcon(tabName: Tab): TopBarActionType {
    return when (tabName.options.title) {
        "Home" -> TopBarActionType.EVENTS
        "My events" -> TopBarActionType.MY_EVENTS
        "Account" -> TopBarActionType.PROFILE
        else -> TopBarActionType.NONE
    }
}

@Composable
private fun getToolbarActionColor(tabName: Tab): Color {
    return when (tabName.options.title) {
        "Home" -> ColorLightGray
        "My events" -> ColorLightGray
        "Account" -> ColorPurple
        else -> ColorLightGray
    }
}

@Composable
private fun getToolbarTitleColor(tabName: Tab): Color {
    return when (tabName.options.title) {
        "Home" -> Color.Black
        "My events" -> Color.Black
        "Account" -> Color.White
        else -> Color.Black
    }
}