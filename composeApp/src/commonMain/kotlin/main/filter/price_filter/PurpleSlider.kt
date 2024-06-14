package main.filter.price_filter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.ColorLightPurple
import ui.ColorPurple
import ui.ColorWhite
import ui.TextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurpleSlider(
    minValue: Float,
    maxValue: Float,
    slideStep: Int,
    onTextChanged: (Float) -> Unit
) {
    var value by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .padding(
                horizontal = 12.dp
            )
    ) {
        Slider(
            value = value,
            onValueChange = { newValue ->
                val steppedValue = (newValue / slideStep).toInt() * slideStep.toFloat()
                if (steppedValue != value) {
                    value = steppedValue
                    onTextChanged(steppedValue)
                }
            },
            valueRange = minValue..maxValue,
            colors = SliderDefaults.colors(
                thumbColor = ColorWhite,
                activeTrackColor = ColorPurple,
                inactiveTrackColor = ColorLightPurple
            ),
            modifier = Modifier
                .fillMaxWidth(),
            thumb = {
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .background(
                            color = ColorWhite,
                            shape = CircleShape
                        )
                        .border(
                            BorderStroke(
                                width = 1.dp,
                                color = TextGray
                            ),
                            shape = RoundedCornerShape(30.dp)
                        )
                )
            }
        )
    }
}