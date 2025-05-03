package com.example.temphilt.di

import com.example.temphilt.model.ImageProvider
import com.example.temphilt.model.ImageProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ImageModule {
    @Binds
    @Singleton
    abstract fun getImage(imageProviderImpl: ImageProviderImpl) : ImageProvider
}