package util

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_hamburger_menu
import eventhubapplication.composeapp.generated.resources.ic_qr_code
import eventhubapplication.composeapp.generated.resources.logout
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import ui.FontSemiBold

@ExperimentalMaterial3Api
@Composable
fun TopBarHeader(
    titleColor: Color = Color.Black,
    title: String,
    backgroundColor: Color = Color.White,
    isLoggedIn: Boolean = false,
    navigationActionType: TopBarActionType = TopBarActionType.NONE,
    onIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 32.sp,
                fontFamily = FontSemiBold(),
                color = titleColor
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor
        ),
        modifier = Modifier
            .padding(
                end = if (navigationActionType != TopBarActionType.PROFILE) 16.dp else 0.dp
            ),
        actions = {
            if (navigationActionType == TopBarActionType.EVENTS && isLoggedIn) {
                Image(
                    painter = painterResource(Res.drawable.ic_hamburger_menu),
                    contentDescription = "Logo image",
                    modifier = Modifier
                        .size(
                            30.dp
                        )
                        .clickable {
                            onIconClick()
                        }
                )
            } else if (navigationActionType == TopBarActionType.MY_EVENTS) {
                Image(
                    painter = painterResource(Res.drawable.ic_qr_code),
                    contentDescription = "Logo image",
                    modifier = Modifier
                        .size(
                            30.dp
                        )
                        .clickable {
                            onIconClick()
                        }
                )
            } else if (navigationActionType == TopBarActionType.PROFILE) {
                LinkText(
                    text = stringResource(Res.string.logout),
                    color = Color.White,
                    modifier = Modifier
                        .padding(
                            end = 16.dp
                        )
                        .clickable {
                            onIconClick()
                        }
                )
            }
        }
    )
}

enum class TopBarActionType {
    NONE,
    PROFILE,
    EVENTS,
    MY_EVENTS
}