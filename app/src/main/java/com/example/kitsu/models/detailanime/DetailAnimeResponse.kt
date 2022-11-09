package com.example.kitsu.models.detailanime

import com.google.gson.annotations.SerializedName

data class DetailAnimeResponse(
    @SerializedName("data")
    val data: DetailAnimeModel
)