package com.capwaydemo


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.capwaydemo.model.ArticlesEntity
import com.capwaydemo.ui.newsFeed.NewsFeedViewModel
import com.capwaydemo.ui.newsFeed.NewsFeedViewModel.NewsFeedFilterState.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.collections.mutableListOf as mutableListOf1


@ExperimentalCoroutinesApi
class ViewModelTest {
    @Rule
    @JvmField
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: NewsFeedViewModel

    @Before
    fun setUp() {
        viewModel = NewsFeedViewModel()
    }

    @Test
    fun testState1() {
        viewModel.clickFilterItem(ALL)
        assertEquals(ALL, viewModel.filterStateLiveData.value)
    }

    @Test
    fun testState2() {
        viewModel.clickFilterItem(BUSINESS)
        assertEquals(BUSINESS, viewModel.filterStateLiveData.value)
    }

    @Test
    fun testState3() {
        viewModel.clickFilterItem(GADGETS)
        assertEquals(GADGETS, viewModel.filterStateLiveData.value)
    }

    @Test
    fun testState4() {
        viewModel.clickFilterItem(SPORT)
        assertEquals(SPORT, viewModel.filterStateLiveData.value)
    }

    @Test
    fun testState5() {
        viewModel.clickFilterItem(VIDEO)
        assertEquals(VIDEO, viewModel.filterStateLiveData.value)
    }

    @Test
    fun testEmptyState1() {
        viewModel.updateNewsFeed(null)
        assertEquals(null, viewModel.newsFeedItemsLiveData.value)
        assertEquals(true, viewModel.showEmptyStateLiveData.value)
    }

    @Test
    fun testEmptyState2() {
        val emptyList: List<ArticlesEntity> = mutableListOf1()
        viewModel.updateNewsFeed(emptyList)
        assertEquals(null, viewModel.newsFeedItemsLiveData.value)
        assertEquals(true, viewModel.showEmptyStateLiveData.value)
    }

    @Test
    fun testEmptyState3() {
        val list = kotlin.collections.mutableListOf<ArticlesEntity>()
        list.add(ArticlesEntity("sdf", "sdf", "sdf", "sdf", "sdf", "sdf", null, "dsf"))
        viewModel.updateNewsFeed(list)
        assertEquals(list, viewModel.newsFeedItemsLiveData.value)
        assertEquals(false, viewModel.showEmptyStateLiveData.value)
    }
}


