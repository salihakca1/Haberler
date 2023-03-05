package com.example.jchaberuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jchaberuygulamasi.entity.Article
import com.example.jchaberuygulamasi.repo.NewsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HealthViewModel @Inject constructor(private val repository: NewsDaoRepository): ViewModel() {
    var healthList = MutableLiveData<List<Article>>()

    init {
        healthNews()
        healthList = repository.getHealthNews()
    }

    fun healthNews(){
        repository.healthNews()
    }

}