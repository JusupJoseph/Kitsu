package com.example.kitsu.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kitsu.databinding.ItemAnimeBinding
import com.example.kitsu.models.anime.AnimeModel
import com.example.kitsu.ui.OnItemClick

class AnimeAdapter(private val list: ArrayList<AnimeModel>, val onItemClick: OnItemClick) :
    RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder =
        AnimeViewHolder(
            ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) : ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(model: AnimeModel) {
            binding.ivPosterImage.load(model.attributes.posterImage.mediumImage)
            binding.tvAnimeTitle.text = model.attributes.titles

            itemView.setOnClickListener {
                onItemClick.onItemClicker(model)
            }

            setupView(model)
        }

        private fun setupView(model: AnimeModel) {
            if (binding.tvAnimeTitle.maxLines != 1) {
                binding.tvAnimeTitle.maxLines = 1
                binding.tvAnimeTitle.text = model.attributes.titles + "..."
            }
        }
    }

    fun addNewItem(animeModel: List<AnimeModel>) {
        list.addAll(animeModel)
        notifyDataSetChanged()
    }
}