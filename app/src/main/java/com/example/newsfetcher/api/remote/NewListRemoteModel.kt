package com.example.newsfetcher.api.remote

import com.google.gson.annotations.SerializedName

data class NewListRemoteModel(
    @SerializedName("results")
    val result: List<NewsRemoteModel> = emptyList()
)