package com.example.jchaberuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jchaberuygulamasi.entity.Article
import com.example.jchaberuygulamasi.repo.NewsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class LastMinuteViewModel @Inject constructor(private val repository: NewsDaoRepository): ViewModel() {


    var lastMinuteList = MutableLiveData<List<Article>>()

    init {
        lastMinuteNews()
        lastMinuteList = repository.getLastMinuteNews()
    }
    fun lastMinuteNews(){
        repository.lastMinuteNews()
    }
}