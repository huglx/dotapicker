package com.task.data

import com.hugl.peekme.domain.Heroes
import com.hugl.peekme.remote.Resource
import kotlinx.coroutines.flow.Flow


interface DataRepositorySource {
    suspend fun requestHeroes(): Flow<Resource<Heroes>>

}
