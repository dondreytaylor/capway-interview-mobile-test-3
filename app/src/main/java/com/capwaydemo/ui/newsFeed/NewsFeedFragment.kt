package com.capwaydemo.ui.newsFeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.capwaydemo.R
import com.capwaydemo.databinding.FragmentNewsFeedBinding
import com.capwaydemo.model.ArticlesEntity
import com.capwaydemo.ui.newsFeed.NewsFeedViewModel.NewsFeedFilterState.*

class NewsFeedFragment : Fragment(), OnArticleClickListener {
    private val viewModel: NewsFeedViewModel by activityViewModels()
    private var _binding: FragmentNewsFeedBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNewsFeedBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadingLiveData.observe(viewLifecycleOwner, { visible ->
            binding.pbLoading.visibility = if (visible) VISIBLE else GONE
        })

        viewModel.showEmptyStateLiveData.observe(viewLifecycleOwner, { showEmptyState ->
            binding.tvEmptyState.visibility = if (showEmptyState) VISIBLE else GONE
        })

        viewModel.filterStateLiveData.observe(viewLifecycleOwner, { filterState ->
            updateButtonState(filterState)
        })

        viewModel.newsFeedItemsLiveData.observe(viewLifecycleOwner, { items ->
            if (!items.isNullOrEmpty()) setData(items)
        })

        binding.ivBell.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.out_of_scope), Toast.LENGTH_LONG).show()
        }
        binding.ivMenu.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.out_of_scope), Toast.LENGTH_LONG).show()
        }
        binding.tvAll.setOnClickListener {
            viewModel.clickFilterItem(ALL)
        }
        binding.tvBusiness.setOnClickListener {
            viewModel.clickFilterItem(BUSINESS)
        }
        binding.tvGadgets.setOnClickListener {
            viewModel.clickFilterItem(GADGETS)
        }
        binding.tvSports.setOnClickListener {
            viewModel.clickFilterItem(SPORT)
        }
        binding.tvVideo.setOnClickListener {
            viewModel.clickFilterItem(VIDEO)
        }
    }

    private fun setData(items: List<ArticlesEntity>) {
        binding.rv.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(this.context)
            adapter = NewsFeedAdapter(requireContext(), items, this@NewsFeedFragment)
        }
    }

    private fun updateButtonState(state: NewsFeedViewModel.NewsFeedFilterState) {
        viewModel.getNewsFeed(state)
        when (state) {
            ALL -> {
                binding.tvAll.background = getDrawable(requireContext(), R.drawable.background_rounded)
                binding.tvBusiness.background = null
                binding.tvGadgets.background = null
                binding.tvSports.background = null
                binding.tvVideo.background = null

                binding.tvAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                binding.tvBusiness.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvGadgets.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvSports.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvVideo.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }
            BUSINESS -> {
                binding.tvAll.background = null
                binding.tvBusiness.background = getDrawable(requireContext(), R.drawable.background_rounded)
                binding.tvGadgets.background = null
                binding.tvSports.background = null
                binding.tvVideo.background = null

                binding.tvAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvBusiness.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                binding.tvGadgets.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvSports.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvVideo.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }
            GADGETS -> {
                binding.tvAll.background = null
                binding.tvBusiness.background = null
                binding.tvGadgets.background = getDrawable(requireContext(), R.drawable.background_rounded)
                binding.tvSports.background = null
                binding.tvVideo.background = null

                binding.tvAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvBusiness.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvGadgets.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                binding.tvSports.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvVideo.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }
            SPORT -> {
                binding.tvAll.background = null
                binding.tvBusiness.background = null
                binding.tvGadgets.background = null
                binding.tvSports.background = getDrawable(requireContext(), R.drawable.background_rounded)
                binding.tvVideo.background = null

                binding.tvAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvBusiness.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvGadgets.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvSports.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                binding.tvVideo.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }
            VIDEO -> {
                binding.tvAll.background = null
                binding.tvBusiness.background = null
                binding.tvGadgets.background = null
                binding.tvSports.background = null
                binding.tvVideo.background = getDrawable(requireContext(), R.drawable.background_rounded)

                binding.tvAll.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvBusiness.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvGadgets.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvSports.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.tvVideo.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
        }
    }

    fun navigateToDetailsPage() {
        findNavController().navigate(R.id.action_news_feed_to_details)
    }

    override fun onArticleClickListener(articlesEntity: ArticlesEntity) {
        viewModel.setSelectedArticle(articlesEntity)
        navigateToDetailsPage()
    }

    companion object {
        fun newInstance() = NewsFeedFragment()
    }
}
