package com.example.jchaberuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jchaberuygulamasi.entity.Article
import com.example.jchaberuygulamasi.repo.NewsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class WorldViewModel @Inject  constructor(private val repository: NewsDaoRepository): ViewModel(){
    var worldList = MutableLiveData<List<Article>>()

    init {
        worldNews()
        worldList = repository.getWorldNews()
    }
    fun worldNews(){
        repository.worldNews()
    }
}