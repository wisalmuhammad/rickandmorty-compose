package com.wisal.android.rickandmorty.home

import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.wisal.android.rickandmorty.data.repository.home.HomeRepository
import com.wisal.android.rickandmorty.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {

    internal val uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)

    private val characterFetchingIndex = MutableStateFlow<Int>(0)
//    val charactersList: StateFlow<List<Character>> = characterFetchingIndex.flatMapLatest { page ->
//        homeRepository.fetchCharacters(
//            page = page,
//            onStart = { uiState.tryEmit(HomeUiState.Loading) },
//            onComplete = { uiState.tryEmit(HomeUiState.Idle) },
//            onError = { uiState.tryEmit(HomeUiState.Error(it)) }
//        )
//    }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000),
//        initialValue = emptyList<Character>()
//    )

    val characters: Flow<PagingData<Character>> = homeRepository.getAllCharacters(0)
        .cachedIn(viewModelScope)
        .map { pagingData ->
            pagingData.map { entity ->
                Character(
                    id = entity.id,
                    name = entity.name,
                    image = entity.image
                )
            }
        }

}

@Stable
internal sealed interface HomeUiState {

    data object Idle : HomeUiState

    data object Loading : HomeUiState

    data object Retry: HomeUiState

    data class Error(val message: String?) : HomeUiState
}