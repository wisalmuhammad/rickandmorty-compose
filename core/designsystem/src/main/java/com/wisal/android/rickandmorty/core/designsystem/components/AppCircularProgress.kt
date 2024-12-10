package com.wisal.android.rickandmorty.core.designsystem.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//TODO

@Composable
fun AppCircularProgress() {
    CircularProgressIndicator(
        modifier = Modifier.fillMaxWidth().padding(10.dp).wrapContentWidth(Alignment.CenterHorizontally),
        color = Color.Green
    )
}