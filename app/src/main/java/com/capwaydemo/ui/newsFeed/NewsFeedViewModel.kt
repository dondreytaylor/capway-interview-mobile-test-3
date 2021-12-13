package com.capwaydemo.ui.newsFeed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capwaydemo.model.ArticlesEntity

class NewsFeedViewModel() : ViewModel() {

    val loadingLiveData = MutableLiveData<Boolean>()
    val newsFeedItemsLiveData = MutableLiveData<List<ArticlesEntity>>()

    enum class NewsFeedFilterState {
        ALL, BUSINESS, GADGETS, SPORT, VIDEO
    }

    fun getNewsFeed(searchCriteria: String) {

    }


}