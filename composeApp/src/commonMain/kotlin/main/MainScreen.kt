package main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import main.tabs.HomeTab
import main.tabs.MyEventsTab
import main.tabs.ProfileTab
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
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
        ShowMainContent(navigator = navigator)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ShowMainContent(
        navigator: Navigator
    ) {
        TabNavigator(HomeTab(navigator)) { tabNavigator ->
            Scaffold(
                topBar = {
                    TopBarHeader(
                        titleColor = getToolbarTitleColor(tabNavigator.current),
                        title = getToolbarTitle(tabNavigator.current),
                        backgroundColor = getToolbarActionColor(tabNavigator.current),
                        navigationActionType = getToolbarActionIcon(tabNavigator.current),
                        //todo use real logic later
                        isLoggedIn = true,
                        onIconClick = {}
                    )
                },
                bottomBar = {
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
                        TabNavigationItem(HomeTab(navigator))
                        TabNavigationItem(MyEventsTab(navigator))
                        TabNavigationItem(ProfileTab())
                    }
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

@OptIn(ExperimentalResourceApi::class)
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