package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class AnimeImage(
    @SerializedName("original")
    val mediumImage: String
)
