package com.example.newsfetcher.repository

import com.example.newsfetcher.api.remote.NewListRemoteModel
import io.reactivex.Single

interface NewsRepository {
    fun getNews(): Single<NewListRemoteModel>
}