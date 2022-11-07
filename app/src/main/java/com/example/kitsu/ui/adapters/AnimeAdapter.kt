package com.example.kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kitsu.base.BaseDiffUtilItemCallback
import com.example.kitsu.databinding.ItemAnimeBinding
import com.example.kitsu.models.anime.AnimeModel
import com.example.kitsu.models.anime.AttributesItem

class AnimeAdapter :
    ListAdapter<AnimeModel, AnimeAdapter.AnimeViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder =
        AnimeViewHolder(
            ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class AnimeViewHolder(private val binding: ItemAnimeBinding) : ViewHolder(binding.root) {

        fun onBind(model: AnimeModel) {
            binding.ivPosterImage.load(model.attributes.posterImage.mediumImage)
            binding.tvAnimeTitle.text = model.attributes.titles
        }
    }
}