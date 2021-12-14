package com.capwaydemo.ui.newsFeed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capwaydemo.NewsFeedRepository
import com.capwaydemo.model.ArticlesEntity
import com.capwaydemo.model.GetArticlesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFeedViewModel() : ViewModel() {

    val loadingLiveData = MutableLiveData<Boolean>()
    val showEmptyStateLiveData = MutableLiveData<Boolean>()
    val newsFeedItemsLiveData = MutableLiveData<List<ArticlesEntity>>()
    val selectedArticleLiveData = MutableLiveData<ArticlesEntity>()
    val filterStateLiveData = MutableLiveData<NewsFeedFilterState>()

    enum class NewsFeedFilterState {
        ALL, BUSINESS, GADGETS, SPORT, VIDEO
    }

    init {
        getNewsFeed(NewsFeedFilterState.ALL)
    }

    fun setSelectedArticle(articlesEntity: ArticlesEntity) {
        selectedArticleLiveData.postValue(articlesEntity)
    }

    fun clickFilterItem(state: NewsFeedFilterState) {
        filterStateLiveData.postValue(state)
    }

    fun updateNewsFeed(items: List<ArticlesEntity>?) {
        if (!items.isNullOrEmpty()) {
            newsFeedItemsLiveData.postValue(items)
            showEmptyStateLiveData.postValue(false)
        } else {
            showEmptyStateLiveData.postValue(true)
        }
    }

    fun getNewsFeed(newsFeedFilterState: NewsFeedFilterState) {
        loadingLiveData.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            NewsFeedRepository.getNewsFeed(newsFeedFilterState.name, "2021-12-13", object : Callback<GetArticlesResponse> {
                override fun onFailure(call: Call<GetArticlesResponse>, t: Throwable) {
                    loadingLiveData.postValue(false)
                    updateNewsFeed(null)
                }

                override fun onResponse(call: Call<GetArticlesResponse>, response: Response<GetArticlesResponse>) {
                    loadingLiveData.postValue(false)
                    updateNewsFeed(response.body()?.articles)
                }
            })
        }
    }
}