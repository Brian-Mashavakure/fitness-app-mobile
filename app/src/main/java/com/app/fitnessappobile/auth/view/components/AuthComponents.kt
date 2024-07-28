package com.app.fitnessappobile.auth.view.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text

@Composable
fun ClickableAccountText(
    mainText: String,
    clickableText: String,
    clickFunction: () -> Unit
){
    val builder = StringBuilder()
    builder.append(mainText)
        .append(clickableText)

    Text(
        modifier = Modifier.clickable { clickFunction() },
        text = builder.toString()
    )

}