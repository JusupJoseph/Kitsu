package com.example.kitsu.ui.fragments.anime

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.common.Resource
import com.example.kitsu.databinding.FragmentAnimeBinding
import com.example.kitsu.models.anime.AnimeModel
import com.example.kitsu.ui.OnItemClick
import com.example.kitsu.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime),
    OnItemClick {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(arrayListOf(), this)
    private var offset: Int = 0

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToAnime()
    }

    override fun setupListener() {
        binding.rvAnime.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    binding.progressBar.visibility = View.VISIBLE
                    offset += 20
                    subscribeToAnime()
                } else {
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvAnime.adapter = animeAdapter
    }

    private fun subscribeToAnime() {
        lifecycleScope.launch {
            viewModel.fetchAnime(20, offset).collect {
                when (it) {
                    is Resource.Error -> {
                        Log.e("anime", it.message.toString())
                    }
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.let { it1 -> animeAdapter.addNewItem(it1.result) }
                    }
                }
            }
        }
    }

    override fun onItemClicker(model: AnimeModel) {
        val bundle = Bundle()
        bundle.putSerializable("id", model.id)
        findNavController().navigate(
            AnimeFragmentDirections.actionAnimeFragmentToDetailAnimeFragment().setId(model.id)
        )
    }
}