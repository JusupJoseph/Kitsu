package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("large")
    val original: String
)