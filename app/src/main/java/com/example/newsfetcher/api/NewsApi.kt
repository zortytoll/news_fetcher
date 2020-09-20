package com.example.newsfetcher.api

import com.example.newsfetcher.api.remote.NewListRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

private const val API_KEY = "nScG42SL5qHcaAvJqel3RkiGCODqqbJ3"

interface NewsApi {

    @GET("topstories/v2/science.json?api-key=${API_KEY}")
    fun getNews(): Single<NewListRemoteModel>
}