package com.capwaydemo.ui.FeedDetails


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.capwaydemo.databinding.FragmentArticleDetailsBinding

class ArticleDetailsFragment : Fragment() {

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

    }

    companion object {
        fun newInstance() = ArticleDetailsFragment()
    }

}
