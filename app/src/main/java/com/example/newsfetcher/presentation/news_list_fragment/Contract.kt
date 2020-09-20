package com.example.newsfetcher.presentation.news_list_fragment

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.presentation.news_list_fragment.adapter.ArticleItem

data class ViewState(
    val newsList: List<ArticleItem> = emptyList()
)

sealed class UiEvent : Event {
}

sealed class DataEvent : Event {
    data class ListAcquired(val list: List<ArticleItem>) : DataEvent()
}