package com.example.kitsu.models

import com.google.gson.annotations.SerializedName
import java.sql.ClientInfoStatus

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
    @SerializedName("coverImage")
    val coverImage: CoverImage,
    @SerializedName("episodeCount")
    val episodeCount: Int,
    @SerializedName("showType")
    val showType: String,
    @SerializedName("status")
    val status: String
)