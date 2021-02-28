package com.task.data.remote.service

import com.hugl.peekme.domain.Models
import retrofit2.Response
import retrofit2.http.GET

interface HeroesService {
    @GET("heroes")
    suspend fun fetchHeroes(): Response<List<Models.Hero>>
}
