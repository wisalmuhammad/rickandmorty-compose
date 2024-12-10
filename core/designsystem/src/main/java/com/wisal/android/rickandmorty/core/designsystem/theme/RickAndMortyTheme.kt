package com.wisal.android.rickandmorty.core.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.core.view.WindowCompat
import com.wisal.android.rickandmorty.core.designsystem.R

private val LocalColors = compositionLocalOf<RickAndMortyColors> {
    error("No colors provided")
}


@Composable
fun RickAndMortyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: RickAndMortyColors = if (darkTheme) {
        RickAndMortyColors.defaultDarkColors()
    } else {
        RickAndMortyColors.defaultLightColors()
    },
    content: @Composable () -> Unit
) {


    val view = LocalView.current
    if (!view.isInEditMode) {
        with((view.context as Activity).window) {
            //statusBarColor = if (darkTheme) colorResource(R.color.colorPrimaryDark).toArgb() else
            WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(this,view).isAppearanceLightNavigationBars = !darkTheme
        }
    }

    CompositionLocalProvider(
       LocalColors provides colors,
    ) {
        content()
    }
}

/**
 * Accessors fro different properties
 */

object RickAndMortyTheme {
    val colors: RickAndMortyColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

}