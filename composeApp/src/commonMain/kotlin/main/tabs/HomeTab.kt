package main.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.FadeTransition
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_tab_home
import eventhubapplication.composeapp.generated.resources.tab_home
import main.home.HomeScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class HomeTab(
    val navigator: Navigator
) : Tab {
    @Composable
    override fun Content() {
        Navigator(HomeScreen(navigator)) {
            FadeTransition(it)
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.ic_tab_home)
            val name = stringResource(Res.string.tab_home)
            return remember {
                TabOptions(
                    index = 0u,
                    title = name,
                    icon = icon
                )
            }
        }
}