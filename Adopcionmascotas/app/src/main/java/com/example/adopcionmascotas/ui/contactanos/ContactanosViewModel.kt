package com.example.adopcionmascotas.ui.contactanos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactanosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
//        value = "This is contactanos Fragment"
    }
    val text: LiveData<String> = _text
}