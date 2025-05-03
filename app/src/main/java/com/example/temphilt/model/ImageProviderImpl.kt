package com.example.temphilt.model

import javax.inject.Inject

class ImageProviderImpl @Inject constructor() : ImageProvider {
    override fun showImage() {
        println("Edrr Showing Image")
    }
}