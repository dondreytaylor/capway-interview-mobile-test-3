package com.capwaydemo.ui.newsFeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.capwaydemo.R
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

        binding.ivBell.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.out_of_scope), Toast.LENGTH_LONG).show()
        }
        binding.ivMenu.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.out_of_scope), Toast.LENGTH_LONG).show()
        }
    }

    fun navigateToDetailsPage() {
        findNavController().navigate(R.id.action_news_feed_to_details)
    }


    companion object {
        fun newInstance() = NewsFeedFragment()
    }

}
