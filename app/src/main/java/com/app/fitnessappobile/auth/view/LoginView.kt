package com.app.fitnessappmobile.auth.view

import android.app.Activity
import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.app.destinations.DashboardViewDestination
import com.app.destinations.SignUpViewDestination
import com.app.fitnessappmobile.ui.theme.*
import com.app.fitnessappobile.R
import com.app.fitnessappobile.auth.view.components.ClickableAccountText
import com.app.fitnessappobile.auth.viewmodel.AuthViewModel
import com.app.fitnessappobile.components.EmailTextFieldComponent
import com.app.fitnessappobile.components.NormalButtonComponent
import com.app.fitnessappobile.components.NormalTextFieldComponent
import com.app.fitnessappobile.components.PasswordTextFieldComponent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@Destination
@Composable
fun LoginView(
    navController: DestinationsNavigator,
    viewModel: AuthViewModel = hiltViewModel()
){

    val scope = rememberCoroutineScope()

    //lifecycle
    val lifeCycleOwner = LocalLifecycleOwner.current

    //snackbar host state
    val snackbarHostState = remember { SnackbarHostState() }

    var username by remember{ mutableStateOf("")}
    var password by remember{mutableStateOf("")}

    Scaffold (
        containerColor = Background,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState){snackbarData ->
                Snackbar(
                    snackbarData = snackbarData,
                    containerColor = ErrorColor,
                    shape = RoundedCornerShape(12.dp),
                    contentColor = TextColor
                )
            }
        },
        modifier = Modifier
            .fillMaxSize(),
        ) { contentPadding ->

        Box(
            modifier = Modifier.fillMaxSize().padding(contentPadding)
        ){

            //MAIN PAGE SECTION
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .zIndex(2f),
                horizontalAlignment = Alignment.Start,
            ){
                //login text
                Text(
                    text = stringResource(id = R.string.login),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = TextColor
                )

                //welcome back text
                Text(
                    text = stringResource(id = R.string.welcome_back),
                    fontSize = 18.sp,
                    color = TextColor
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

                //text boxes
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    NormalTextFieldComponent(
                        textFieldValue = username,
                        labelFieldValue = stringResource(id = R.string.username),
                        onValueChanged = {username = it}
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    PasswordTextFieldComponent(
                        textValue = password,
                        onValueChanged = {password = it}
                    )
                    //forgot password text
                    Box(
                        modifier =  Modifier.width(350.dp),
                        contentAlignment = Alignment.CenterEnd
                    ){
                        Text(
                            modifier = Modifier.clickable {  },
                            text = stringResource(id = R.string.forgot_password),
                            textDecoration = TextDecoration.Underline,
                            color = TextColor
                        )

                    }
                }

                //login button
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    NormalButtonComponent(
                        onclickFunction = {
                            viewModel.loginUser(
                                username,
                                password
                            )
                            viewModel.loginStatus.observe(lifeCycleOwner){ status ->
                                if(status == "Logged"){
                                    navController.navigate(DashboardViewDestination)
                                }else {
                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "Error Trying To Log You In",
                                            duration = SnackbarDuration.Long,
                                            withDismissAction = true,
                                        )
                                    }
                                }
                            }
                        },
                        stringResource = stringResource(id = R.string.login)
                    )
                }

                //have an account text
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ){
                    ClickableAccountText(
                        mainText = stringResource(id = R.string.dont_have_an_account),
                        clickableText = stringResource(id = R.string.signup),
                        clickFunction = {
                            navController.navigate(SignUpViewDestination)
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
                        radius = 200.dp.toPx(),
                    )
                }
            )

        }


    }
}

