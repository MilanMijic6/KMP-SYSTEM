package main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import ui.ColorLightGray
import ui.ColorPurple
import util.HeaderText
import util.LinkText
import util.RoundedImage
import util.RoundedTextInput

class ProfileScreen(
    val navigator: Navigator
) : Screen {

    @Composable
    override fun Content() {
        ShowMainContent(
            navigator = navigator
        )
    }

    @Composable
    private fun ShowMainContent(
        navigator: Navigator
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(
                    color = ColorLightGray
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = ColorLightGray
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(
                                color = ColorPurple
                            )
                    )
                    RoundedImage(
                        modifier = Modifier
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HeaderText(
                        text = "Milan Mijic",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(
                                top = 20.dp
                            )
                    )
                    LinkText(
                        text = "8m ago",
                        textAlign = TextAlign.End,
                        color = ColorPurple,
                        textSize = 14.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 20.dp,
                                end = 16.dp
                            )
                    )
                    RoundedTextInput(
                        text = "Milan Mijic"
                    ) {

                    }
                    LinkText(
                        text = "30m ago",
                        textAlign = TextAlign.End,
                        color = ColorPurple,
                        textSize = 14.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 30.dp,
                                end = 16.dp
                            )
                    )
                    RoundedTextInput(
                        text = "milan.mijic@vegait.rs",
                        modifier = Modifier
                            .padding(
                                bottom = 30.dp
                            )
                    ) {

                    }
                }
            }
        }
    }
}