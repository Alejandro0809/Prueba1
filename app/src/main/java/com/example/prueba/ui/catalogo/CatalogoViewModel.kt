package com.example.prueba.ui.catalogo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CatalogoViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is catalogo f"
    }
    val text: LiveData<String> = _text
}