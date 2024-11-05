package com.app.fitnessappobile.main_package.view

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.destinations.CommunityViewDestination
import com.app.destinations.DashboardViewDestination
import com.app.destinations.ProfileViewDestination
import com.app.destinations.SettingsViewDestination
import com.app.fitnessappmobile.ui.theme.Background
import com.app.fitnessappmobile.ui.theme.LightSecondaryColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun DashboardView(
    navigator: DestinationsNavigator
){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Background,
        bottomBar = {
            BottomNavBar(
                onNavigateDashboard = {navigator.navigate(DashboardViewDestination)},
                onNavigateCommunity = {navigator.navigate(CommunityViewDestination)},
                onNavigateSettings = {navigator.navigate(SettingsViewDestination)},
                onNavigateProfile = {navigator.navigate(ProfileViewDestination)},
                navController = navigator
            )
        }
    )
    { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .scrollable(
                    state = ScrollableState {
                        it
                    },
                    enabled = true,
                    orientation = Orientation.Vertical,
                    reverseDirection = true,
                )
        ){


        }
    }
}