package com.wisal.android.rickandmorty.data.repository.details

import androidx.annotation.WorkerThread
import com.wisal.android.rickandmorty.core.database.CharacterInfoDao
import com.wisal.android.rickandmorty.core.database.entity.mapper.asDomain
import com.wisal.android.rickandmorty.core.database.entity.mapper.asEntity
import com.wisal.android.rickandmorty.model.CharacterInfo
import com.wisal.android.rickandmorty.network.Dispatcher
import com.wisal.android.rickandmorty.network.RickAndMortyAppDispatchers
import com.wisal.android.rickandmorty.network.service.RickAndMortyClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import javax.inject.Inject


class DetailsRepositoryImp @Inject constructor(
    private val apiClient: RickAndMortyClient,
    private val characterInfoDao: CharacterInfoDao,
    @Dispatcher(RickAndMortyAppDispatchers.IO)
    private val ioDispatcher: CoroutineDispatcher,
) : DetailsRepository {

    @WorkerThread
    override fun fetchPokemonInfo(
        id: Int,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<CharacterInfo> = flow {
            val characterInfo = characterInfoDao.getCharacterInfo(id)
            if (characterInfo == null) {
                try {
                    val response = apiClient.fetchCharacterInfoById(id)
                    if (response.isSuccessful) {
                        characterInfoDao.insertCharacterInfo(response.body()?.asEntity()!!)
                        emit(response.body()!!)
                    }
                } catch (ex: Exception) {
                    onError(ex.localizedMessage)
                }
            } else {
                emit(characterInfo.asDomain())
            }
        }.onCompletion { onComplete() }.flowOn(ioDispatcher)
}