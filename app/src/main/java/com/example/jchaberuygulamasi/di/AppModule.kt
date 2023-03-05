package com.example.jchaberuygulamasi.di


import com.example.jchaberuygulamasi.retrofit.NewsDaoInterface
import com.example.jchaberuygulamasi.repo.NewsDaoRepository
import com.example.jchaberuygulamasi.retrofit.ApiUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideNewsDaoRepository(ndao: NewsDaoInterface): NewsDaoRepository{
        return NewsDaoRepository(ndao)
    }

    @Provides
    @Singleton
    fun provideNewsDao(): NewsDaoInterface {
        return ApiUtils.getNewsDaoInterface()
    }
}