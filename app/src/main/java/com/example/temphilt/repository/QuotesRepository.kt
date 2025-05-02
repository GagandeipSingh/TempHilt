package com.example.temphilt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.temphilt.api_service.QuotesApiService
import com.example.temphilt.model.QuotesModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuotesRepository @Inject constructor(val api: QuotesApiService) {
    private var quotesLiveData = MutableLiveData<List<QuotesModelItem>>()
    val quotesData: LiveData<List<QuotesModelItem>>
        get() = quotesLiveData
    suspend fun getQuotes() {
        val response = api.getQuotes()
        if (response.isSuccessful && response.body() != null) {
            withContext(Dispatchers.Main) {
                quotesLiveData.value = response.body()
            }
        }
    }
}