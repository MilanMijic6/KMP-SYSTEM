package main.filter.price_filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.ColorPurple
import ui.FontRegular

@Composable
fun PriceLabelRow(
    modifier: Modifier = Modifier,
    title: String,
    priceValueStart: Int,
    priceValueEnd: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = Color.Black,
            textAlign = TextAlign.Start,
            fontFamily = FontRegular(),
            fontSize = 16.sp
        )

        Text(
            text = "$$priceValueStart-$${priceValueEnd}",
            color = ColorPurple,
            textAlign = TextAlign.End,
            fontFamily = FontRegular(),
            fontSize = 18.sp
        )
    }
}