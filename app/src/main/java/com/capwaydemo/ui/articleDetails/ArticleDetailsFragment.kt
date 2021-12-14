package com.capwaydemo.ui.articleDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.capwaydemo.R
import com.capwaydemo.databinding.FragmentArticleDetailsBinding
import com.capwaydemo.model.ArticlesEntity
import com.capwaydemo.ui.newsFeed.NewsFeedViewModel

class ArticleDetailsFragment : Fragment() {
    private val viewModel: NewsFeedViewModel by activityViewModels()
    private var _binding: FragmentArticleDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentArticleDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.ivShare.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.not_part_of_scope), Toast.LENGTH_LONG).show()
        }

        viewModel.selectedArticleLiveData.observe(viewLifecycleOwner, { article ->
            if (article != null) setData(article)
        })
    }

    private fun setData(article: ArticlesEntity) {
        article.urlToImage.let { Glide.with(requireContext()).load(it).into(binding.ivMainIcon) }
        binding.tvTitle.text = article.title
        binding.tvAuthor.text = article.author
        binding.tvSummary.text = article.description
        binding.tvContent.text = article.content
    }

    companion object {
        fun newInstance() = ArticleDetailsFragment()
    }

}
