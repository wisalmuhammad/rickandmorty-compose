package com.wisal.android.rickandmorty.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wisal.android.rickandmorty.core.designsystem.components.AppCircularProgress
import com.wisal.android.rickandmorty.core.designsystem.R
import com.wisal.android.rickandmorty.core.designsystem.components.RickAndMortyAppBar
import com.wisal.android.rickandmorty.core.designsystem.theme.RickAndMortyTheme
import com.wisal.android.rickandmorty.model.Character


@Composable
internal fun HomeScreen(
    lazyPagingItems: LazyPagingItems<Character>,
    onItemClick: (Character) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        RickAndMortyAppBar()

        HomeContent(
            pagingItems = lazyPagingItems,
            onItemClick = onItemClick
        )
    }

}

@Composable
private fun HomeContent(
    pagingItems: LazyPagingItems<Character>,
    onItemClick: (Character) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(6.dp),
        ) {
            items(pagingItems.itemCount) { index ->
                pagingItems[index]?.let {
                    CharacterCard(
                        it,
                        onItemClick = onItemClick
                    )
                }
            }

            pagingItems.apply {
                when {
                    loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                        item(span = { GridItemSpan(2) }) {
                            AppCircularProgress()
                        }
                    }
                    loadState.refresh is LoadState.Error-> {
                        val error = loadState.refresh as LoadState.Error
                        item(span = { GridItemSpan(2) }) {
                            ErrorMessage(
                                message = error.error.localizedMessage!!,
                                onClickRetry = { retry() }
                            )
                        }
                    }

                    loadState.append is LoadState.Error -> {
                        val error = pagingItems.loadState.append as LoadState.Error
                        item(span = { GridItemSpan(2) }) {
                            ErrorMessage(
                                modifier = Modifier,
                                message = error.error.localizedMessage!!,
                                onClickRetry = { retry() }
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun CharacterCard(
    character: Character,
    onItemClick: (Character) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .testTag("Pokemon")
            .clickable {
                onItemClick(character)
            },
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = RickAndMortyTheme.colors.primaryContainer)
    ) {
        GlideImage(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .aspectRatio(1f),
            model = character.image,
            contentScale= ContentScale.Fit,
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(12.dp),
            text = character.name,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            color = RickAndMortyTheme.colors.textColor
        )
    }
}

@Composable
fun ErrorMessage(
    message: String,
    modifier: Modifier = Modifier,
    onClickRetry: () -> Unit
) {
    Row(
        modifier = modifier.padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = message,
            color = RickAndMortyTheme.colors.errorColor,
            modifier = Modifier.weight(1f),
            maxLines = 2,
        )
        OutlinedButton(onClick = onClickRetry) {
            Text(
                text = stringResource(id = R.string.retry),
                color = RickAndMortyTheme.colors.textColor
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewCharacterCard() {
    CharacterCard(
        Character(
            id = 0,
            name = "Name",
            image = "url"
        ),
        { _ ->

        }
    )
}

@Preview
@Composable
fun PreviewErrorMessage() {
    ErrorMessage(
        "Error msg",
        onClickRetry = {

        }
    )
}