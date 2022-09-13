package com.example.memoryleaksemminar.mvvm_leak

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Project: MemoryLeakSeminar
 * Created by ThuyHV5 on 9/8/2022.
 * Used to
 */
class SecondLeakViewModel(application: Application) : AndroidViewModel(application) {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val repository = Repository()
    private var callback: ((String) -> Unit)? = {
        Log.d("SecondViewModel", "request network result $it")
    }

    fun performNetworkRequest() {
        scope.launch {
            repository.performRequest("http://212.183.159.230/50MB.zip",callback)
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}