package com.app.fitnessappobile.workouts.view

import android.widget.NumberPicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappmobile.ui.theme.GreyBackground
import com.app.fitnessappmobile.ui.theme.SecondaryColor
import com.app.fitnessappobile.R
import com.app.fitnessappobile.components.NormalTextFieldComponentWithoutIcon
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AddWorkoutView(){
    //data input
    var workoutNickname by remember { mutableStateOf("") }
    var warmupActivity by remember { mutableStateOf("") }
    var cardioActivity by remember { mutableStateOf("") }
    var strengthActivity by remember { mutableStateOf("") }
    var coreActivity by remember { mutableStateOf("") }
    var flexActivity by remember { mutableStateOf("") }
    var cooldownActivity by remember { mutableStateOf("") }
    //TODO: Autopick usernames
    var userName by remember { mutableStateOf("") }
    var warmupTime by remember { mutableStateOf(0) }
    var cardioTime by remember { mutableStateOf(0) }
    var strengthTime by remember { mutableStateOf(0) }
    var coreTime by remember { mutableStateOf(0) }
    var flexTime by remember { mutableStateOf(0) }
    var cooldownTime by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize().background(color = Background)
    ){innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(innerPadding).fillMaxSize().background(color = GreyBackground)
        ){
            Box(
                modifier = Modifier.padding(15.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = stringResource(id = R.string.workout_details)
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            NormalTextFieldComponentWithoutIcon(
                textFieldValue = workoutNickname,
                labelFieldValue = "workout nickname",
                onValueChanged = {workoutNickname = it}
            )

            NormalTextFieldComponentWithoutIcon(
                textFieldValue = warmupActivity,
                labelFieldValue = "warmup activity",
                onValueChanged = {workoutNickname = it}
            )


            NormalTextFieldComponentWithoutIcon(
                textFieldValue = cardioActivity,
                labelFieldValue = "cardio activity",
                onValueChanged = {cardioActivity = it}
            )

            NormalTextFieldComponentWithoutIcon(
                textFieldValue = strengthActivity,
                labelFieldValue = "strength activity",
                onValueChanged = {strengthActivity = it}
            )

            NormalTextFieldComponentWithoutIcon(
                textFieldValue = coreActivity,
                labelFieldValue = "core activity",
                onValueChanged = {coreActivity = it}
            )

            NormalTextFieldComponentWithoutIcon(
                textFieldValue = flexActivity,
                labelFieldValue = "flexibility activity",
                onValueChanged = {flexActivity = it}
            )

            NormalTextFieldComponentWithoutIcon(
                textFieldValue = cooldownActivity,
                labelFieldValue = "cooldown activity",
                onValueChanged = {cooldownActivity = it}
            )

            NormalTextFieldComponentWithoutIcon(
                textFieldValue = userName,
                labelFieldValue = "username",
                onValueChanged = {userName = it}
            )
        }

    }
}

