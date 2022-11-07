package com.example.kitsu.data.repositories

import com.example.kitsu.base.BaseRepository
import com.example.kitsu.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    fun fetchAnime() = doRequest {
        service.fetchAnime()
    }
}