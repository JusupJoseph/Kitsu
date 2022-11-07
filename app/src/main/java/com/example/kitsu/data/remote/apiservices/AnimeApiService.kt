package com.example.kitsu.data.remote.apiservices

import com.example.kitsu.models.AnimeResponse
import com.example.kitsu.models.anime.AnimeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): Response<AnimeResponse>
}