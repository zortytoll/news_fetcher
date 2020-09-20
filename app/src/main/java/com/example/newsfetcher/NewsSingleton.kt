package com.example.newsfetcher

import com.example.newsfetcher.api.NewsApi
import com.example.newsfetcher.repository.NewsRepositoryImpl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RepositoryProvider {
    private const val BASE_URL = "https://api.nytimes.com/svc/"

    fun newRepositoryInstance(): NewsRepositoryImpl {
        val api = newApiInstance()
        return NewsRepositoryImpl(api)
    }

    fun newApiInstance(): NewsApi {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(NewsApi::class.java)
    }
}