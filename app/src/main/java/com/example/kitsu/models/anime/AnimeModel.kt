package com.example.kitsu.models.anime

import com.example.kitsu.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class AnimeModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("attributes")
    val attributes: AttributesItem
): IBaseDiffModel<Int>