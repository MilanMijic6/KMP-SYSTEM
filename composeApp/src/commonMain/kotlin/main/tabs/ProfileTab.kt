package main.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.FadeTransition
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_tab_profile
import eventhubapplication.composeapp.generated.resources.tab_profile
import main.profile.ProfileScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class ProfileTab(
    val navigator: Navigator
) : Tab {
    @Composable
    override fun Content() {
        Navigator(ProfileScreen()) {
            FadeTransition(it)
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.ic_tab_profile)
            val name = stringResource(Res.string.tab_profile)
            return remember {
                TabOptions(
                    index = 0u,
                    title = name,
                    icon = icon
                )
            }
        }
}