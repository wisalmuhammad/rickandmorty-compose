package com.wisal.android.rickandmorty.core.designsystem.components

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.wisal.android.rickandmorty.core.designsystem.R
import com.wisal.android.rickandmorty.core.designsystem.theme.RickAndMortyColors
import com.wisal.android.rickandmorty.core.designsystem.theme.RickAndMortyTheme


@Composable
fun RickAndMortyAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = RickAndMortyTheme.colors.textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = RickAndMortyTheme.colors.primaryContainer,
        ),
    )
}

@Preview
@Composable
private fun RickAndMortyAppBarPreview() {
    RickAndMortyTheme {
        RickAndMortyAppBar()
    }
}