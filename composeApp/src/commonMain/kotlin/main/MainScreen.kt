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
import eventhubapplication.composeapp.generated.resources.tab_profile
import main.tabs.HomeTab
import main.tabs.MyEventsTab
import main.tabs.ProfileTab
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import util.TabNavigationItem
import util.TopBarHeader

class MainScreen(
    val navigator: Navigator
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
        TabNavigator(HomeTab(navigator)) {
            Scaffold(
                topBar = {
                    TopBarHeader(
                        title = getToolbarTitle(it.current),
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
                            )
                    ) {
                        TabNavigationItem(HomeTab(navigator))
                        TabNavigationItem(MyEventsTab(navigator))
                        TabNavigationItem(ProfileTab(navigator))
                    }
                },
                containerColor = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(it)
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