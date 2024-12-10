package com.wisal.android.rickandmorty.feature.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wisal.android.rickandmorty.model.Character
import com.wisal.android.rickandmorty.model.CharacterInfo
import com.wisal.android.rickandmorty.core.designsystem.R
import com.wisal.android.rickandmorty.core.designsystem.components.AppCircularProgress
import com.wisal.android.rickandmorty.core.designsystem.theme.RickAndMortyTheme


@Composable
internal fun DetailsScreen(
    uiState: DetailsUiState,
    character: Character?,
    characterInfo: CharacterInfo?,
    onNavigateUp : () -> Unit
) {
    DetailsScreenContent(
        uiState,
        character,
        characterInfo,
        onNavigateUp = onNavigateUp
    )
}


@Composable
private fun DetailsScreenContent(
    uiState: DetailsUiState,
    character: Character?,
    characterInfo: CharacterInfo?,
    onNavigateUp : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        HeaderCard(
            character,
            onNavigateUp = onNavigateUp
        )

        if (uiState == DetailsUiState.Idle && characterInfo != null) {
            DetailCard(characterInfo)
        }

        if (uiState == DetailsUiState.Loading) {
            AppCircularProgress()
        }

    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun HeaderCard(
    character: Character?,
    onNavigateUp : () -> Unit
) {
    val shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 64.dp,
        bottomEnd = 64.dp,
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .shadow(2.dp,shape)
            .statusBarsPadding(),
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = RickAndMortyTheme.colors.primaryContainer)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 8.dp, end = 6.dp)
                    .size(28.dp)
                    .clip(CircleShape)
                    .clickable { onNavigateUp() },
                painter = painterResource(id = R.drawable.arrow_back_24),
                tint = RickAndMortyTheme.colors.textColor,
                contentDescription = null,
            )

            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = character?.name.orEmpty(),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = RickAndMortyTheme.colors.textColor
            )

            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "ID: ${character?.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = RickAndMortyTheme.colors.textColor
            )
        }

        GlideImage(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(190.dp)
                .aspectRatio(1f)
                .padding(top = 8.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            model = character?.image,
            contentDescription = ""
        )

    }
}

@Composable
private fun DetailCard(
    characterInfo: CharacterInfo
) {
    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .shadow(2.dp, RoundedCornerShape(16.dp))
            .verticalScroll(rememberScrollState()),
        colors = CardDefaults.cardColors(containerColor = RickAndMortyTheme.colors.primaryContainer)
    ) {
        ColumnRow("gender", characterInfo.gender)
        ColumnRow("species",characterInfo.species)
        ColumnRow("status",characterInfo.status)
        ColumnRow("created",characterInfo.created)
    }
}


@Composable
private fun ColumnRow(
    key: String,
    value: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            key.replaceFirstChar { it.uppercase() },
            color = RickAndMortyTheme.colors.textColor,
        )
        Text(
            "$value",
            color = RickAndMortyTheme.colors.textColor,
        )
    }
}

@Preview
@Composable
fun PreviewHeaderCard() {
    HeaderCard(
        Character(
            id = 0,
            name = "Dummy Name",
            image = "",
        ),
        {}
    )
}

@Preview
@Composable
fun PreviewDetailsCard() {
    DetailCard(
        CharacterInfo(
            id = 0,
            name = "Dummy Name",
            image = "",
            created = "2/3/2024",
            gender = "Male",
            species = "Human",
            status = "Alive",
            type = "",
            url = "",
            origin = CharacterInfo.NameUrl("Earth",""),
            location = CharacterInfo.NameUrl("",""),
            episode = listOf()
        )
    )
}