package com.app.fitnessappobile.components

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappmobile.ui.theme.HighlightColor
import com.app.fitnessappmobile.ui.theme.SecondaryColor
import com.app.fitnessappmobile.ui.theme.TextColor
import com.app.fitnessappobile.R
import kotlin.math.sin

//import androidx.compose.runtime.remember


@Composable
fun EmailTextFieldComponent(){
    var textValue by remember{mutableStateOf("")}

    OutlinedTextField(
        label = {Text(text = stringResource(id = R.string.email))},
        value = textValue,
        onValueChange = {textValue = it},
        colors = TextFieldDefaults.colors(
            focusedLabelColor = TextColor,
            focusedContainerColor = Background,
            focusedIndicatorColor = TextColor,
            cursorColor = Background,
            unfocusedContainerColor = Background
        ),
        trailingIcon = { Icon(
            painter = painterResource(id = R.drawable.mail),
            contentDescription = stringResource(id = R.string.email_icon))
        },
        modifier = Modifier.width(330.dp).clip(shape = RoundedCornerShape(8)),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
    )
}


@Composable
fun PasswordTextFieldComponent(){
    var textValue by remember{mutableStateOf("")}
    var passwordVisibilty by remember{mutableStateOf(false)}

    OutlinedTextField(
        label = { Text(text = stringResource(id = R.string.password))},
        value = textValue,
        onValueChange = { textValue = it },
        modifier = Modifier.width(330.dp).clip(shape = RoundedCornerShape(8)),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = TextColor,
            focusedIndicatorColor = TextColor,
            focusedContainerColor = Background,
            cursorColor = Background,
            unfocusedContainerColor = Background
        ),
        trailingIcon = {
            IconButton(
                content = {Icon(
                    painter= painterResource(id = if(passwordVisibilty) R.drawable.visibility else R.drawable.visibility_off ),
                    contentDescription = stringResource(id = R.string.passwordvisibility_icon)
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