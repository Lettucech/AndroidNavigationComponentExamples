package io.github.lettucech.navcompexamples.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToolbarViewModel : ViewModel() {
    val toolbarTitle: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}