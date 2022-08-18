package com.example.memoryleaksemminar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.memoryleaksemminar.R

class ThreadContextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        DownloadTask(this).start()
    }

    class DownloadTask(var context: Context) : Thread() {
        override fun run() {
            super.run()
            val s = context.getString(R.string.app_name)
            SystemClock.sleep(200000)
        }
    }
}
