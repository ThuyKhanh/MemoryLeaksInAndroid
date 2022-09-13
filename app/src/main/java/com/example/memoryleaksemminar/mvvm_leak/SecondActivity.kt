package com.example.memoryleaksemminar.mvvm_leak

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.memoryleaksemminar.R

class SecondActivity : AppCompatActivity() {
//    private val viewModel: SecondLeakViewModel by viewModels()
    private val viewModel: SecondViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        viewModel.performNetworkRequest()
    }
}