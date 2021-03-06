package com.mctable.globo_challenge.commons.di

import com.mctable.globo_challenge.commons.utils.Constants
import com.mctable.globo_challenge.home.data.api.HomeWebService
import com.mctable.globo_challenge.home.domain.repository.HomeRepository
import com.mctable.globo_challenge.moviedetails.data.api.MovieDetailsWebService
import com.mctable.globo_challenge.moviedetails.domain.repository.MovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    //Retrofit
    @Provides
    fun getRetrofitInstance() = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    //Web Services
    @Provides
    fun getHomeWebService(retrofit: Retrofit) = retrofit
        .create(HomeWebService::class.java)

    @Provides
    fun getMovieDetailsWebService(retrofit: Retrofit) =
        retrofit.create(MovieDetailsWebService::class.java)

    //Repositorys
    @Provides
    fun getHomeRepository(webService: HomeWebService) = HomeRepository(webService)

    @Provides
    fun getMovieDetailsRepository(webService: MovieDetailsWebService) =
        MovieDetailsRepository(webService)
}