package com.example.kitsu.models

import com.example.kitsu.models.anime.AnimeModel
import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val result: List<AnimeModel>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)