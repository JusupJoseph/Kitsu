package com.example.kitsu.models.anime

import com.example.kitsu.models.Links
import com.example.kitsu.models.Meta
import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val result: List<AnimeModel>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)