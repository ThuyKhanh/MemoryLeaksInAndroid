package com.example.memoryleaksemminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;

public class ThreadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        new DownloadTask().start();
    }
    static class DownloadTask extends Thread{
        @Override
        public void run() {
            super.run();
            SystemClock.sleep(200000);
        }
    }
}


