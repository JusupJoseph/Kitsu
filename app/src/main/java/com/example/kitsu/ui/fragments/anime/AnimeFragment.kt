package com.example.kitsu.ui.fragments.anime

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.common.Resource
import com.example.kitsu.databinding.FragmentAnimeBinding
import com.example.kitsu.models.anime.AttributesItem
import com.example.kitsu.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToAnime()
    }

    private fun setupRecyclerView() {
        binding.rvAnime.adapter = animeAdapter
    }

    private fun subscribeToAnime() {
        lifecycleScope.launch {
            viewModel.fetchAnime().collect {
                when (it) {
                    is Resource.Error -> {
                        Log.e("anime", it.message.toString())
                        Toast.makeText(requireContext(), it.data?.result.toString(), Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        animeAdapter.submitList(it.data?.result)
                        Toast.makeText(requireContext(), it.data?.result.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}