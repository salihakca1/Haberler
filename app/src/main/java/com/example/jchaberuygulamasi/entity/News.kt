package com.example.jchaberuygulamasi.entity


import com.example.jchaberuygulamasi.entity.Article
import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    var articles: List<Article>,
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int
)