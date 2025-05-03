package com.example.temphilt.di

import android.content.Context
import android.content.SharedPreferences
import com.example.temphilt.api_service.QuotesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
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

    @Provides
    @Singleton
    @Str1
    fun getString1() : String{
        return "Hello1"
    }

    @Provides
    @Singleton
    @Named("str2")
    fun getString2() : String{
        return "Hello2"
    }

    @Provides
    @Singleton
    @UiPref
    fun getUiPrefs(@ApplicationContext context: Context) : SharedPreferences{
        return context.getSharedPreferences("ui_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    @LoginPrefs
    fun getLoginPrefs(@ApplicationContext context: Context) : SharedPreferences{
        return context.getSharedPreferences("ui_prefs", Context.MODE_PRIVATE)
    }
}