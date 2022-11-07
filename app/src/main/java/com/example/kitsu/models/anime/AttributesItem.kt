package com.example.kitsu.models.anime

import com.example.kitsu.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class AttributesItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("coverImageTopOffset")
    val coverImageTopOffset: Int,
    @SerializedName("canonicalTitle")
    val titles: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("popularityRank")
    val popularityRank: Int,
    @SerializedName("posterImage")
    val posterImage: AnimeImage,
    @SerializedName("episodeCount")
    val episodeCount: Int
)