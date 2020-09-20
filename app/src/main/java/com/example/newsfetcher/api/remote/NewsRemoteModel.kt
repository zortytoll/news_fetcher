package com.example.newsfetcher.api.remote

import com.google.gson.annotations.SerializedName

data class NewsRemoteModel(

    @SerializedName("title")
    val title: String,

    @SerializedName("abstract")
    val abstract: String
)