package com.example.jchaberuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jchaberuygulamasi.entity.Article
import com.example.jchaberuygulamasi.repo.NewsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class TechnologyViewModel @Inject constructor(private val repository: NewsDaoRepository): ViewModel() {
    var technologyList = MutableLiveData<List<Article>>()

    init {
        technologyNews()
        technologyList = repository.getTechnologyNews()
    }

    fun technologyNews(){
        repository.technologyNews()
    }

}