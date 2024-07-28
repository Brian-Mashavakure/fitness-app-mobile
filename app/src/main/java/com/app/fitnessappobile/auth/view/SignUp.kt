package com.app.fitnessappmobile.auth.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappmobile.ui.theme.SecondaryColor

@Composable
fun SignUp(
    modifier: Modifier
){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Background,
    ) {
        Canvas(
            modifier = modifier.fillMaxSize(),
            onDraw = {
                drawCircle(
                    color = SecondaryColor,
                    center = Offset(
                        x = 400.dp.toPx(),
                        y = 100.dp.toPx(),
                    ),
                    radius = 230.dp.toPx(),
                )
            }
        )

    }
}