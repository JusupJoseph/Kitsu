package com.example.kitsu.ui

import com.example.kitsu.models.anime.AnimeModel

interface OnItemClick {

    fun onItemClicker(model: AnimeModel)
}