package com.mctable.globo_challenge.commons.di

import com.mctable.globo_challenge.commons.utils.Constants
import com.mctable.globo_challenge.home.data.api.HomeWebService
import com.mctable.globo_challenge.home.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    //Web Services
    @Provides
    fun getHomeWebService() = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(HomeWebService::class.java)

    //Repositorys
    @Provides
    fun getHomeRepository(webService: HomeWebService) = HomeRepository(webService)
}