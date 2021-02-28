package com.task.data.remote

import android.util.Log
import com.hugl.peekme.domain.Heroes
import com.hugl.peekme.domain.Models
import com.hugl.peekme.remote.Resource
import com.hugl.peekme.utils.NetworkConnectivity
import com.task.data.remote.service.HeroesService
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator, private val networkConnectivity: NetworkConnectivity) : RemoteDataSource {

    override suspend fun requestHeroes(): Resource<Heroes> {
        val heroesService = serviceGenerator.createService(HeroesService::class.java)
        return when (val response = processCall(heroesService::fetchHeroes)) {
            is List<*> -> {
                Resource.Success(data = Heroes(response as ArrayList<Models.Hero>))
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return -1
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            -2
        }
    }
}
