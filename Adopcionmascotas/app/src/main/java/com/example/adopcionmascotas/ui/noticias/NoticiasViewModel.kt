package com.example.adopcionmascotas.ui.noticias

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoticiasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is noticias Fragment"
    }
    val text: LiveData<String> = _text
}