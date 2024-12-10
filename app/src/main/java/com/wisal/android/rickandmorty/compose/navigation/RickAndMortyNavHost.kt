package com.wisal.android.rickandmorty.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wisal.android.rickandmorty.feature.details.navigation.detailsScreen
import com.wisal.android.rickandmorty.home.navigation.homeScreen
import com.wisal.android.rickandmorty.navigation.RickAndMortyScreen

private const val TAG = "RickAndMortyNavHost"

@Composable
fun RickAndMortyNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        startDestination = RickAndMortyScreen.Home,
        navController = navController,
        modifier = modifier
    ) {
        homeScreen { character ->
            navController.navigate(RickAndMortyScreen.Details(character))
        }
        detailsScreen(
            onNavigateUp = {
                navController.navigateUp()
            }
        )
    }
}