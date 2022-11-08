package com.example.kitsu.data.remote.apiservices

import com.example.kitsu.models.anime.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int = 10,
        @Query("page[offset]") offset: Int = 1
    ): Response<AnimeResponse>
}