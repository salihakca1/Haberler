package com.example.jchaberuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jchaberuygulamasi.entity.Article
import com.example.jchaberuygulamasi.repo.NewsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class PoliticViewModel @Inject constructor(private val repository: NewsDaoRepository): ViewModel() {
    var politicList = MutableLiveData<List<Article>>()

    init {
        politicNews()
        politicList = repository.getPoliticNews()
    }

    fun politicNews(){
        repository.politicNews()
    }

}