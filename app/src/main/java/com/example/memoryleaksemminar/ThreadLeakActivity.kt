package com.example.memoryleaksemminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class ThreadLeakActivity : AppCompatActivity() {
    private lateinit var downloadTask: DownloadTask
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        downloadTask = DownloadTask()
        downloadTask.start()
    }
    class DownloadTask: Thread(){
        override fun run() {
            super.run()
            SystemClock.sleep(200000)
        }
    }
}


