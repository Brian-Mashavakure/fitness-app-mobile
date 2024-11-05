package com.app.fitnessappobile.main_package.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.app.destinations.AddWorkoutViewDestination
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappmobile.ui.theme.LightSecondaryColor
import com.app.fitnessappmobile.ui.theme.TextColor
import com.app.fitnessappobile.R
import com.app.fitnessappobile.workouts.view.AddWorkoutView
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun BottomNavBar(
    onNavigateDashboard: () -> Unit,
    onNavigateCommunity: () -> Unit,
    onNavigateSettings: () -> Unit,
    onNavigateProfile: () -> Unit,
    navController: DestinationsNavigator
){
    var menuExpanded by remember{ mutableStateOf(false) }

    //nav bar
    BottomAppBar (
        containerColor = Background,
        contentPadding = PaddingValues(all = 8.dp),
        modifier = Modifier.shadow(elevation = 10.dp),
        actions = {
                IconButton(
                    onClick = { onNavigateDashboard() },
                ){
                    Icon(painter = painterResource(id = R.drawable.dashboard), contentDescription = "Dashboard")
                }

                IconButton(
                    onClick = { onNavigateCommunity() },
                ){
                    Icon(painter = painterResource(id = R.drawable.community), contentDescription = "Community")
                }

                IconButton(
                    onClick = { onNavigateSettings() },
                ){
                    Icon(painter = painterResource(id = R.drawable.settings), contentDescription = "Settings")
                }

                IconButton(
                    onClick = { onNavigateProfile() },
                ){
                    Icon(painter = painterResource(id = R.drawable.person), contentDescription = "Profile")
                }
        },

        floatingActionButton = {
            Box(
                modifier = Modifier.fillMaxSize().background(color = Background),
                contentAlignment = Alignment.CenterEnd
            ){
                IconButton(
                    onClick = {
                        menuExpanded = true
                    },
                ){
                    Icon(painter = painterResource(id = R.drawable.add_circle), contentDescription = "Add", modifier = Modifier.size(28.dp))
                }


                DropdownMenu(
                    modifier = Modifier.background(color = Background),
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false }
                ){
                    DropdownMenuItem(
                        onClick = {
                            navController.navigate(AddWorkoutViewDestination)
                        },
                        text = {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Icon(painter = painterResource(id = R.drawable.workout), contentDescription = "Workout", tint = TextColor, modifier =  Modifier.size(18.dp))
                                Spacer(
                                    modifier = Modifier.width(10.dp)
                                )
                                Text(
                                    "Add Workout",
                                    style = TextStyle(
                                        color = TextColor
                                    )
                                )
                            }
                        },
                    )

                    Divider()

                    DropdownMenuItem(
                        onClick = {},
                        text = {
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ){
                                Icon(painter = painterResource(id = R.drawable.running), contentDescription = "Run", tint = TextColor, modifier =  Modifier.size(18.dp))

                                Spacer(
                                    modifier = Modifier.width(10.dp)
                                )

                                Text(
                                    "Add Run",
                                    style = TextStyle(
                                        color = TextColor
                                    )
                                )
                            }
                        },
                    )

                    Divider()

                    DropdownMenuItem(
                        onClick = {},
                        text = {
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ){
                                Icon(painter = painterResource(id = R.drawable.calendar), contentDescription = "Goal", tint = TextColor, modifier =  Modifier.size(18.dp))

                                Spacer(
                                    modifier = Modifier.width(10.dp)
                                )

                                Text(
                                    "Add Goal",
                                    style = TextStyle(
                                        color = TextColor
                                    )
                                )
                            }
                        },
                    )

                    Divider()
                }
            }
        },
    )

}