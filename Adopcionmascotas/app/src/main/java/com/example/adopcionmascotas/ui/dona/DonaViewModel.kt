package com.example.adopcionmascotas.ui.dona

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DonaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dona Fragment"
    }
    val text: LiveData<String> = _text
}