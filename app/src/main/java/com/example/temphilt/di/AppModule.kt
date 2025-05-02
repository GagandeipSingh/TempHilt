package com.example.temphilt.di

import com.example.temphilt.api_service.QuotesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // LifeTime
//@InstallIn(ActivityComponent::class)
object AppModule {
//    @Provides
////    @Singleton // Instances
//    @ActivityScoped
//    fun getEngine() : Engine{
//        return Engine()
//    }
//
//    @Provides
//    @ActivityScoped
//    fun getCar(engine: Engine) : Car{
//        return Car(engine)
//    }

    @Provides
    @Singleton
    fun getApiService() : QuotesApiService{
        val baseUrl = "https://jsonplaceholder.typicode.com/"
        val apiService by lazy {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuotesApiService::class.java)
        }
        return apiService
    }
}