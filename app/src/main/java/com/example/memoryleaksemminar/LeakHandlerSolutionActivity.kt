package com.example.memoryleaksemminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.memoryleaksemminar.R
import java.lang.ref.WeakReference

class LeakHandlerSolutionActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak_handler)
        val container = findViewById<ConstraintLayout>(R.id.container)
        handler.postDelayed(CustomRunnable(WeakReference(container)),
            1000 * 100)
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
    private class CustomRunnable(var view: WeakReference<View>)
        : Runnable {
        override fun run() {
            view.get()?.let {
                it.setBackgroundColor(
                    ContextCompat.getColor(it.context,
                        R.color.purple_700)
                )
            }
        }
    }
}
