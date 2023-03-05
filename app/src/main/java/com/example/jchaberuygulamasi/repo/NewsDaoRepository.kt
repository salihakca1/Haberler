package com.example.jchaberuygulamasi.repo

import androidx.lifecycle.MutableLiveData
import com.example.jchaberuygulamasi.retrofit.NewsDaoInterface
import com.example.jchaberuygulamasi.entity.Article
import com.example.jchaberuygulamasi.entity.News
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsDaoRepository @Inject constructor(var ndao: NewsDaoInterface) {

    var lastMinuteList = MutableLiveData<List<Article>>()
    var worldList = MutableLiveData<List<Article>>()
    var headlineList = MutableLiveData<List<Article>>()
    var docketList = MutableLiveData<List<Article>>()
    var healthList = MutableLiveData<List<Article>>()
    var politicList = MutableLiveData<List<Article>>()
    var scienceList = MutableLiveData<List<Article>>()
    var sportList = MutableLiveData<List<Article>>()
    var technologyList = MutableLiveData<List<Article>>()
    var lifeList = MutableLiveData<List<Article>>()
    var cultureList = MutableLiveData<List<Article>>()

    init {
        cultureList = MutableLiveData()
        lifeList = MutableLiveData()
        technologyList = MutableLiveData()
        sportList = MutableLiveData()
        scienceList = MutableLiveData()
        politicList = MutableLiveData()
        healthList = MutableLiveData()
        docketList = MutableLiveData()
        worldList = MutableLiveData()
        headlineList = MutableLiveData()
        lastMinuteList = MutableLiveData()
    }

    fun getCultureNews(): MutableLiveData<List<Article>>{
        return cultureList
    }

    fun getLifeNews(): MutableLiveData<List<Article>>{
        return lifeList
    }

    fun getTechnologyNews(): MutableLiveData<List<Article>>{
        return technologyList
    }

    fun getSportNews(): MutableLiveData<List<Article>>{
        return sportList
    }

    fun getScienceNews(): MutableLiveData<List<Article>>{
        return scienceList
    }

    fun getPoliticNews(): MutableLiveData<List<Article>>{
        return politicList
    }

    fun getHealthNews(): MutableLiveData<List<Article>>{
        return healthList
    }
    fun getDocketNews(): MutableLiveData<List<Article>>{
        return docketList
    }
    fun getWorldNews(): MutableLiveData<List<Article>>{
        return worldList
    }

    fun getHeadlineNews(): MutableLiveData<List<Article>>{
        return headlineList
    }

    fun getLastMinuteNews(): MutableLiveData<List<Article>>{
        return lastMinuteList
    }


    fun lastMinuteNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.lastMinuteNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        lastMinuteList.value = list
                    }

                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }

    fun headlineNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.headlineNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        headlineList.value = list
                    }

                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }

    fun worldNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.worldNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        worldList.value = list
                    }
                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }

    fun docketNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.docketNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        docketList.value = list
                    }
                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }

    fun healthNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.healthNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        healthList.value = list
                    }
                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }

    fun politicNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.politicNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        politicList.value = list
                    }

                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }

    fun scienceNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.scienceNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        scienceList.value = list
                    }

                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }

    fun sportNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.sportNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        sportList.value = list
                    }

                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }

    fun technologyNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.technologyNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        technologyList.value = list
                    }

                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }
    fun lifeNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.lifeNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        lifeList.value = list
                    }

                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }
    fun cultureNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val job6: Deferred<Unit> = async {
                ndao.cultureNews().enqueue(object : Callback<News>{
                    override fun onResponse(call: Call<News>, response: Response<News>) {

                        val list = response.body().articles
                        cultureList.value = list
                    }

                    override fun onFailure(call: Call<News>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }
                })
            }
            job6.await()
        }
    }
}