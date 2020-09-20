package com.example.newsfetcher.navigator

import com.example.newsfetcher.presentation.news_list_fragment.adapter.ArticleItem

interface Navigator {
    fun navigateToArticle(item: ArticleItem)
}