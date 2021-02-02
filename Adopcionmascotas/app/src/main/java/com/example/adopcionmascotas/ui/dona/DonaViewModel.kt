package com.example.adopcionmascotas.ui.dona

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DonaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Dona"
    }
    val text: LiveData<String> = _text
}