package com.example.kitsu.ui.fragments.detailanime

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.common.Resource
import com.example.kitsu.databinding.FragmentDetailAnimeBinding
import com.example.kitsu.models.AttributesItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailAnimeFragment :
    BaseFragment<FragmentDetailAnimeBinding, DetailAnimeViewModel>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    override val viewModel: DetailAnimeViewModel by viewModels()
    private val saveArgs: DetailAnimeFragmentArgs by navArgs<DetailAnimeFragmentArgs>()

    override fun setupListener() {

    }

    override fun setupSubscribe() {
        lifecycleScope.launch {
            viewModel.fetchDetailAnime(saveArgs.id.toString()).collect {
                when (it) {
                    is Resource.Error -> {
                        Log.e("anime", it.message.toString())
                    }
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.data?.attributesItem?.let { it1 -> addDataInView(it1) }
                    }
                }
            }
        }
    }

    private fun addDataInView(model: AttributesItem) {
        binding.ivCoverImage.load(model.coverImage.original)
        binding.ivPosterImage.load(model.posterImage.mediumImage)
        binding.tvTitle.text = model.titles
        binding.tvEpisodeCount.text = model.episodeCount.toString()
        binding.tvStatus.text = model.status
        binding.tvShowType.text = model.showType
        binding.tvPopularityRank.text = model.popularityRank.toString()
    }
}