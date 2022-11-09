package com.example.kitsu.data.remote.apiservices

import com.example.kitsu.models.detailanime.DetailAnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailAnimeApiService {

    @GET("anime/{id}")
    suspend fun fetchDetailsAnime(
        @Path("id") id: String
    ): Response<DetailAnimeResponse>
}