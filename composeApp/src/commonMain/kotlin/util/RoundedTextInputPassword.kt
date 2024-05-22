package util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.BackgroundGray
import ui.ColorPurple
import ui.TextGray

@Composable
fun RoundedTextInputPassword(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
) {
    var value by rememberSaveable { mutableStateOf("") }
    val isFocused by rememberSaveable { mutableStateOf(false) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                value = it
                onTextChanged.invoke(it)
            },
            maxLines = 1,
            modifier = modifier
                .padding(
                    horizontal = 16.dp
                )
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(
                fontSize = 16.sp
            ),
            visualTransformation = if (passwordVisible)
                VisualTransformation.None else PasswordVisualTransformation(mask = '\u25CF'),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BackgroundGray,
                focusedIndicatorColor = ColorPurple,
                unfocusedIndicatorColor = TextGray
            ),
            label = {
                Text(
                    text = text,
                    color = getColor(isFocused, value.isNotEmpty()),
                    fontSize = 16.sp
                )
            },
            trailingIcon = {
                Text(
                    text = if (passwordVisible) "Hide" else "Show",
                    color = ColorPurple,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(
                            end = 12.dp
                        )
                        .clickable {
                            passwordVisible = !passwordVisible
                        }
                )
            }
        )
    }
}

@Composable
private fun getColor(
    isFocused: Boolean,
    isEmpty: Boolean
): Color {
    return if (isFocused) Color.Black
    else {
        if (!isEmpty) TextGray
        else ColorPurple
    }
}