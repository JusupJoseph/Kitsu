package com.example.kitsu.models.detailanime

import com.example.kitsu.models.AttributesItem
import com.google.gson.annotations.SerializedName

data class DetailAnimeModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("attributes")
    val attributesItem: AttributesItem
)