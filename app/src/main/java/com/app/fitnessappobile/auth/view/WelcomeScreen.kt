package com.app.fitnessappmobile.auth.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappmobile.ui.theme.HighlightColor
import com.app.fitnessappmobile.ui.theme.SecondaryColor
import com.app.fitnessappmobile.ui.theme.TextColor
import com.app.fitnessappobile.R
import com.app.fitnessappobile.components.NormalButtonComponent

@Composable
fun WelcomeScreen(
    modifier: Modifier
){
   Surface(
       modifier = modifier.fillMaxSize(),
       color = Background,
       ){
       Column(
           modifier = modifier.fillMaxHeight().padding(20.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
           horizontalAlignment = Alignment.CenterHorizontally
       ){
           //vector image
           Image(
               painter = painterResource(id = R.drawable.welcome),
               contentDescription = "Picture of lady working out",
           )

           //text section
           Column(
               modifier = modifier.fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally
           ){
               Text(
                   text = stringResource(id = R.string.welcome),
                   fontWeight = FontWeight.Bold,
                   fontSize = 30.sp,
               )

               Spacer(modifier = modifier.height(5.dp))

               Text(
                   text = stringResource(id = R.string.welcome_text_1),
                   fontSize = 16.sp,
                   overflow = TextOverflow.Ellipsis
               )

               Text(
                   text = stringResource(id = R.string.welcome_text_2),
                   fontSize = 16.sp,
                   overflow = TextOverflow.Ellipsis
               )
           }


           //button
           NormalButtonComponent(
               onclickFunction = { },
               stringResource = stringResource(id = R.string.get_started)
           )
       }

   }
}