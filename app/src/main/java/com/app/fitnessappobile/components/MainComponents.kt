package com.app.fitnessappobile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fitnessappmobile.ui.theme.*
import com.app.fitnessappobile.R
import org.w3c.dom.Text
import kotlin.math.sin

@Composable

fun NormalTextFieldComponent(
    textFieldValue: String,
    labelFieldValue: String,
    onValueChanged: (String) -> Unit
){

    OutlinedTextField(
        label = {Text(text = labelFieldValue)},
        value = textFieldValue,
        textStyle = TextStyle(
            color = TextColor
        ),
        onValueChange = onValueChanged,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = TextColor,
            focusedContainerColor = Background,
            unfocusedContainerColor = Background,
            focusedIndicatorColor = TextColor,
            unfocusedLabelColor = TextColor,
            unfocusedIndicatorColor = TextColor
        ),
        trailingIcon = { Icon(
            painter = painterResource(id = R.drawable.person),
            contentDescription = stringResource(id = R.string.person_icon),
            tint = TextColor
            )
        },
        modifier = Modifier
            .width(330.dp).width(2.dp),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
    )

}


@Composable
fun EmailTextFieldComponent(
   textFieldValue: String,
   onValueChanged: (String) -> Unit,
){

    OutlinedTextField(
        label = {Text(text = stringResource(id = R.string.email))},
        value = textFieldValue,
        onValueChange = onValueChanged,
        textStyle = TextStyle(
            color = TextColor
        ),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = TextColor,
            focusedContainerColor = Background,
            unfocusedContainerColor = Background,
            focusedIndicatorColor = TextColor,
            unfocusedLabelColor = TextColor,
            unfocusedIndicatorColor = TextColor
        ),
        trailingIcon = { Icon(
            painter = painterResource(id = R.drawable.mail),
            contentDescription = stringResource(id = R.string.email_icon),
            tint = TextColor
            )
        },
        modifier = Modifier.width(330.dp).width(2.dp),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
    )
}


@Composable
fun PasswordTextFieldComponent(
    textValue : String,
    onValueChanged: (String) -> Unit,
){
    var passwordVisibilty by remember{mutableStateOf(false)}

    OutlinedTextField(
        label = { Text(text = stringResource(id = R.string.password))},
        value = textValue,
        onValueChange = onValueChanged,
        textStyle = TextStyle(
            color = TextColor
        ),
        modifier = Modifier.width(330.dp).width(2.dp),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = TextColor,
            focusedContainerColor = Background,
            unfocusedContainerColor = Background,
            focusedIndicatorColor = TextColor,
            unfocusedLabelColor = TextColor,
            unfocusedIndicatorColor = TextColor
        ),
        trailingIcon = {
            IconButton(
                content = {Icon(
                    painter= painterResource(id = if(passwordVisibilty) R.drawable.visibility else R.drawable.visibility_off ),
                    contentDescription = stringResource(id = R.string.passwordvisibility_icon),
                    tint = TextColor
                )},
                onClick = { passwordVisibilty = !passwordVisibilty},
                )
        },
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if(passwordVisibilty) VisualTransformation.None else PasswordVisualTransformation(),
        )

}


@Composable
fun NormalButtonComponent(
    onclickFunction: () -> Unit,
    stringResource: String
){
    Button(
        modifier = Modifier.height(100.dp).width(300.dp).padding(20.dp),
        onClick = { onclickFunction() },
        colors = ButtonDefaults.buttonColors(
            SecondaryColor,
            TextColor,
            HighlightColor,
            Background
        )
    ){
        Text(
            text = stringResource,
            fontSize = 18.sp
        )
    }
}


@Composable
fun NormalTextFieldComponentWithoutIcon(
    textFieldValue: String,
    labelFieldValue: String,
    onValueChanged: (String) -> Unit
){

    OutlinedTextField(
        label = {Text(text = labelFieldValue)},
        value = textFieldValue,
        textStyle = TextStyle(
            color = TextColor
        ),
        onValueChange = onValueChanged,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = TextColor,
            focusedContainerColor = Background,
            unfocusedContainerColor = Background,
            focusedIndicatorColor = TextColor,
            unfocusedLabelColor = TextColor,
            unfocusedIndicatorColor = TextColor
        ),
        modifier = Modifier
            .width(330.dp).width(2.dp),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
    )

}