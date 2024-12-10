package com.wisal.android.rickandmorty.home.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.wisal.android.rickandmorty.home.HomeScreen
import com.wisal.android.rickandmorty.home.HomeViewModel
import com.wisal.android.rickandmorty.model.Character
import com.wisal.android.rickandmorty.navigation.RickAndMortyScreen


fun NavGraphBuilder.homeScreen(
    onCharacterClick: (Character) -> Unit
) {

    composable<RickAndMortyScreen.Home> {
        val viewModel: HomeViewModel = hiltViewModel()
        val lazyPageItems = viewModel.characters.collectAsLazyPagingItems()
        HomeScreen(
            lazyPagingItems = lazyPageItems,
            onItemClick = onCharacterClick
        )
    }

}