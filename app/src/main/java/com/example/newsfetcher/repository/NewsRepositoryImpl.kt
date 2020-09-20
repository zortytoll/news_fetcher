package com.example.newsfetcher.repository

import com.example.newsfetcher.api.NewsApi
import com.example.newsfetcher.api.remote.NewListRemoteModel
import io.reactivex.Single

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {

    override fun getNews(): Single<NewListRemoteModel> {
        return newsApi.getNews()
    }
}