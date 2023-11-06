package com.example.mydatabindingapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydatabindingapp.model.MemeModel
import com.example.mydatabindingapp.repository.MemesRepository
import kotlinx.coroutines.launch

class MemeViewModel(private val memesRepository: MemesRepository): ViewModel() {
    init {
        viewModelScope.launch {
            memesRepository.getMemes()
        }
    }

    val memes : LiveData<MemeModel>
        get() = memesRepository.memes



}