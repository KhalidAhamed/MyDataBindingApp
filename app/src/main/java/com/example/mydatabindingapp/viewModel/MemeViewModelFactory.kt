package com.example.mydatabindingapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mydatabindingapp.repository.MemesRepository

class MemeViewModelFactory(private val memesRepository: MemesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemeViewModel(memesRepository) as T
    }
}