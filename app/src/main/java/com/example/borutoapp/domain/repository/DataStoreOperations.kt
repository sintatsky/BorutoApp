package com.example.borutoapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {

    suspend fun saveOnBoardingsState(completes: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}