package com.example.newsfetcher.interactor

import com.example.newsfetcher.presentation.news_list_fragment.adapter.ArticleItem
import com.example.newsfetcher.repository.NewsRepository
import io.reactivex.Single

class NewsInteractor(private val repository: NewsRepository) {
    fun getNews(source: String): Single<List<ArticleItem>> {
        return repository.getNews().map {
            it.result.map { article ->
                ArticleItem(article.title, article.abstract)
            }
        }
    }
}