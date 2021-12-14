package com.capwaydemo.ui.newsFeed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.capwaydemo.R
import com.capwaydemo.databinding.FragmentNewsFeedBinding
import com.capwaydemo.model.ArticlesEntity

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

        binding.ivBell.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.out_of_scope), Toast.LENGTH_LONG).show()
        }
        binding.ivMenu.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.out_of_scope), Toast.LENGTH_LONG).show()
        }
        setView()
    }

    fun navigateToDetailsPage() {
        findNavController().navigate(R.id.action_news_feed_to_details)
    }

    fun setView() {

        val items = mutableListOf<ArticlesEntity>()
        items.add(ArticlesEntity("1", "auther", "date", "https://picsum.photos/200", ""))
        items.add(ArticlesEntity("2", "auther", "date", "", ""))
        items.add(ArticlesEntity("3", "auther", "date", "https://picsum.photos/200", ""))
        items.add(ArticlesEntity("4", "auther", "date", "", ""))
        binding.rv.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(this.context)
            adapter = NewsFeedAdapter(requireContext(), items, this@NewsFeedFragment)
        }
    }

    companion object {
        fun newInstance() = NewsFeedFragment()
    }

    override fun onArticleClickListener(articlesEntity: ArticlesEntity) {
        Log.d("jake", "clicking item " + articlesEntity.title)
    }

}
