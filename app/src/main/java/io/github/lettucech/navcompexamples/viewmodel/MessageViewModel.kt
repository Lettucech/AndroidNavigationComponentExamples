package io.github.lettucech.navcompexamples.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel() {
    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}