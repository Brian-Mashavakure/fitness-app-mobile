package com.app.fitnessappobile.main_package.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.NavGraphs
import com.app.destinations.CommunityViewDestination
import com.app.destinations.DashboardViewDestination
import com.app.destinations.ProfileViewDestination
import com.app.destinations.SettingsViewDestination
import com.app.fitnessappmobile.ui.theme.Background
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator



@Destination
@Composable
fun MainView(
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
                onNavigateProfile = {navigator.navigate(ProfileViewDestination)}
            )
        }

    ) { contentPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(contentPadding),
        ){
            DestinationsNavHost(
                navGraph = NavGraphs.root,
            )
        }
    }

}