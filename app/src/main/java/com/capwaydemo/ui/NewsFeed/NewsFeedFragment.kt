package com.capwaydemo.ui.NewsFeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.capwaydemo.databinding.FragmentNewsFeedBinding

class NewsFeedFragment : Fragment() {
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

    }


    companion object {
        fun newInstance() = NewsFeedFragment()
    }

}
