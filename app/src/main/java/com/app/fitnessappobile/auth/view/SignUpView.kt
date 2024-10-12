package com.app.fitnessappmobile.auth.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.destinations.DashboardViewDestination
import com.app.destinations.LoginViewDestination
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappmobile.ui.theme.SecondaryColor
import com.app.fitnessappmobile.ui.theme.TextColor
import com.app.fitnessappobile.R
import com.app.fitnessappobile.auth.view.components.ClickableAccountText
import com.app.fitnessappobile.auth.viewmodel.AuthViewModel
import com.app.fitnessappobile.components.EmailTextFieldComponent
import com.app.fitnessappobile.components.NormalButtonComponent
import com.app.fitnessappobile.components.PasswordTextFieldComponent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignUpView(
    navController: DestinationsNavigator,
    viewModel: AuthViewModel = hiltViewModel()
){

    var emailAddress by remember { mutableStateOf("") }
    var password by remember{ mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            //MAIN PAGE SECTION
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .zIndex(2f),
                horizontalAlignment = Alignment.Start,
            ){
                //create an account text
                Text(
                    text = stringResource(id = R.string.create_account),
                    color = TextColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                )

                //welcome aboard text
                Text(
                    text = stringResource(id = R.string.welcome),
                    fontSize = 23.sp
                )

                //logo
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp).weight(1f, fill = false),
                    contentAlignment =Alignment.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.size(300.dp)
                    )
                }

                //text fields
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    EmailTextFieldComponent(
                        textFieldValue = emailAddress,
                        onValueChanged = {emailAddress = it},
                        )

                    Spacer(modifier = Modifier.height(5.dp))

                    PasswordTextFieldComponent(
                        textValue = password,
                        onValueChanged = {password = it},
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    //confirm passsword
                    PasswordTextFieldComponent(
                        textValue = password,
                        onValueChanged = {password = it},
                    )
                   }


                //login button
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    NormalButtonComponent(
                        onclickFunction = {
                            viewModel.registerUser()
                        },
                        stringResource = stringResource(id = R.string.signup)
                    )
                }


                //already have an account text
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ){
                    ClickableAccountText(
                        mainText = stringResource(id = R.string.already_have_an_account),
                        clickableText = stringResource(id = R.string.login),
                        clickFunction = {
                            navController.navigate(LoginViewDestination)
                        }
                    )
                }
            }

            //ORANGE CIRCLE GRAPHIC
            Canvas(
                modifier = Modifier.fillMaxSize(),
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


    }
