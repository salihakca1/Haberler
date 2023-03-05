package com.example.jchaberuygulamasi.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "https://newsapi.org/"

        fun getNewsDaoInterface(): NewsDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(NewsDaoInterface::class.java)
        }
    }
}