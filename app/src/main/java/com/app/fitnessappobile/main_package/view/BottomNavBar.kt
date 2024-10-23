package com.app.fitnessappobile.main_package.view


import androidx.compose.foundation.layout.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappmobile.ui.theme.LightSecondaryColor
import com.app.fitnessappmobile.ui.theme.TextColor
import com.app.fitnessappobile.R
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun BottomNavBar(
    onNavigateDashboard: () -> Unit,
    onNavigateCommunity: () -> Unit,
    onNavigateSettings: () -> Unit,
    onNavigateProfile: () -> Unit
){
    BottomAppBar (
        containerColor = Background,
        contentPadding = PaddingValues(all = 8.dp),
        modifier = Modifier.shadow(elevation = 10.dp),
        actions = {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
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
            }

        }
    )

}