package com.example.borutoapp.data.repository

import androidx.paging.PagingData
import com.example.borutoapp.domain.model.Hero
import com.example.borutoapp.domain.repository.DataStoreOperations
import com.example.borutoapp.domain.repository.LocalDataSource
import com.example.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val dataStore: DataStoreOperations,
    private val remoteDataSource: RemoteDataSource
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remoteDataSource.getAllHeroes()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remoteDataSource.searchHeroes(query)
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return localDataSource.getSelectedHero(heroId)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingsState(completes = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}