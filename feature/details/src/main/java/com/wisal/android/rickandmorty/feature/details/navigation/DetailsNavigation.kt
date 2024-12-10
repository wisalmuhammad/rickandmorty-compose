package com.wisal.android.rickandmorty.feature.details.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wisal.android.rickandmorty.feature.details.DetailsScreen
import com.wisal.android.rickandmorty.feature.details.DetailsViewModel
import com.wisal.android.rickandmorty.navigation.RickAndMortyScreen


fun NavGraphBuilder.detailsScreen(
    onNavigateUp : () -> Unit
) {
    composable<RickAndMortyScreen.Details>(
        typeMap = RickAndMortyScreen.Details.typeMap
    ) {
        val viewModel: DetailsViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val character by viewModel.character.collectAsStateWithLifecycle()
        val characterInfo by viewModel.characterInfo.collectAsStateWithLifecycle()
        DetailsScreen(
            uiState = uiState,
            character = character,
            characterInfo = characterInfo,
            onNavigateUp = onNavigateUp
        )
    }
}