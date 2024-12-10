package com.wisal.android.rickandmorty.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.wisal.android.rickandmorty.core.designsystem.R

@Immutable
data class RickAndMortyColors(
    val primaryColor: Color,
    val primaryColorDark: Color,
    val primaryContainer: Color,
    val primaryContainerDark: Color,
    val backgroundColor: Color,
    val textColor: Color,
    val errorColor: Color,
    val black: Color,
    val white: Color,
    val grey: Color,
) {

    companion object {

        /**
         * Provides the default colors for the light mode of the app.
         *
         */
        @Composable
        fun defaultLightColors(): RickAndMortyColors = RickAndMortyColors(
            primaryColor = colorResource(R.color.colorPrimary),
            primaryColorDark = colorResource(R.color.colorPrimaryDark),
            backgroundColor = colorResource(R.color.backgroundLight),
            primaryContainer = colorResource(R.color.primaryContainer),
            primaryContainerDark = colorResource(R.color.primaryContainerDark),
            textColor = colorResource(R.color.black),
            errorColor = colorResource(R.color.error),
            black = colorResource(R.color.black),
            white = colorResource(R.color.black),
            grey = colorResource(R.color.grey),
        )

        /**
         * Provides the default colors for the dark mode of the app.
         */

        @Composable
        fun defaultDarkColors(): RickAndMortyColors = RickAndMortyColors(
            primaryColor = colorResource(R.color.colorPrimary_dark),
            primaryColorDark = colorResource(R.color.colorPrimaryDark_dark),
            backgroundColor = colorResource(R.color.background_dark),
            primaryContainer = colorResource(R.color.primaryContainer_dark),
            primaryContainerDark = colorResource(R.color.primaryContainerDark_dark),
            textColor = colorResource(R.color.white),
            black = colorResource(R.color.black),
            white = colorResource(R.color.white),
            grey = colorResource(R.color.grey),
            errorColor = colorResource(R.color.error_dark)
        )
    }

}
