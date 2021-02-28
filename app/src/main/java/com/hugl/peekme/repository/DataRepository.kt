package com.task.data

import com.hugl.peekme.domain.Heroes
import com.hugl.peekme.remote.Resource
import com.task.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class DataRepository @Inject constructor(private val remoteRepository: RemoteData, private val ioDispatcher: CoroutineContext) : DataRepositorySource {

    override suspend fun requestHeroes(): Flow<Resource<Heroes>> {
        return flow {
            emit(remoteRepository.requestHeroes())
        }.flowOn(ioDispatcher)
    }


}
