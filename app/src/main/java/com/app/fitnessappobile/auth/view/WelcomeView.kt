package com.app.fitnessappmobile.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.destinations.MainViewDestination
import com.app.destinations.SignUpViewDestination
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappobile.R
import com.app.fitnessappobile.components.NormalButtonComponent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun WelcomeView(
    navController: DestinationsNavigator
){
   Surface(
       modifier = Modifier.fillMaxSize(),
       color = Background,
       ){
       Column(
           modifier = Modifier.fillMaxHeight().padding(20.dp),
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
               modifier = Modifier.fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally
           ){
               Text(
                   text = stringResource(id = R.string.welcome),
                   fontWeight = FontWeight.Bold,
                   fontSize = 30.sp,
               )

               Spacer(modifier = Modifier.height(5.dp))

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
               onclickFunction = {
                   navController.navigate(SignUpViewDestination)
               },
               stringResource = stringResource(id = R.string.get_started)
           )
       }

   }
}