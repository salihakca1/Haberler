package com.example.jchaberuygulamasi.retrofit

import com.example.jchaberuygulamasi.entity.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsDaoInterface {

    @GET("v2/everything?q=son-dakika&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun lastMinuteNews(): Call<News>

    @GET("v2/everything?q=dünya&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun worldNews(): Call<News>

    @GET("v2/everything?q=manşet&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun headlineNews(): Call<News>

    @GET("v2/everything?q=gündem&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun docketNews(): Call<News>

    @GET("v2/everything?q=sağlık&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun healthNews(): Call<News>

    @GET("v2/everything?q=siyaset&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun politicNews(): Call<News>

    @GET("v2/everything?q=bilim&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun scienceNews(): Call<News>

    @GET("v2/everything?q=spor&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun sportNews(): Call<News>

    @GET("v2/everything?q=teknoloji&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun technologyNews(): Call<News>

    @GET("v2/everything?q=yaşam&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun lifeNews(): Call<News>

    @GET("v2/everything?q=kültür&apiKey=c02e5dd694a94adfa21b3b0dc67e7eba")
    fun cultureNews(): Call<News>
}