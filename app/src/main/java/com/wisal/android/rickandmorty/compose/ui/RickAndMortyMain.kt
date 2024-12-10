package com.wisal.android.rickandmorty.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wisal.android.rickandmorty.compose.navigation.RickAndMortyNavHost
import com.wisal.android.rickandmorty.core.designsystem.theme.RickAndMortyTheme


@Composable
fun RickAndMortyMain() {
    RickAndMortyTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(RickAndMortyTheme.colors.backgroundColor)
        ) {
            RickAndMortyNavHost()
        }
    }
}