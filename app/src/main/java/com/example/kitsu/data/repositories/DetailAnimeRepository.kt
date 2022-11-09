package com.example.kitsu.data.repositories

import com.example.kitsu.base.BaseRepository
import com.example.kitsu.data.remote.apiservices.DetailAnimeApiService
import javax.inject.Inject

class DetailAnimeRepository @Inject constructor(private val service: DetailAnimeApiService) : BaseRepository() {

    fun fetchDetailAnime(id: String) = doRequest {
        service.fetchDetailsAnime(id)
    }
}