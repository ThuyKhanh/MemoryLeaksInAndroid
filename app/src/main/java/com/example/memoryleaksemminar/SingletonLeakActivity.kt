package com.example.memoryleaksemminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SingletonLeakActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleton_leak)
        SingletonManager.getInstance(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}