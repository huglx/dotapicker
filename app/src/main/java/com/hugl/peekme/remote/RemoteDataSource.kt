package com.task.data.remote

import com.hugl.peekme.domain.Heroes
import com.hugl.peekme.domain.Models
import com.hugl.peekme.remote.Resource


internal interface RemoteDataSource {
    suspend fun requestHeroes(): Resource<Heroes>
}
