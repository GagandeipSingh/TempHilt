package com.example.temphilt.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.temphilt.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(val repository: QuotesRepository) : ViewModel(){
    val quotesLivedata = repository.quotesData

    fun getQuotes(){
        viewModelScope.launch (Dispatchers.IO){
            repository.getQuotes()
        }
    }
}