package com.example.kitsu.ui.fragments.detailanime

import com.example.kitsu.base.BaseViewModel
import com.example.kitsu.data.repositories.DetailAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailAnimeViewModel @Inject constructor(private val repository: DetailAnimeRepository) :
    BaseViewModel() {

    fun fetchDetailAnime(id: String) = repository.fetchDetailAnime(id)
}