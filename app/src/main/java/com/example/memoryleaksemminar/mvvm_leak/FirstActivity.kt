package com.example.memoryleaksemminar.mvvm_leak

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.memoryleaksemminar.R

class FirstActivity : AppCompatActivity() {
    val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        setContentView(R.layout.activity_mvvmleak_main)
        val btn = findViewById<Button>(R.id.btn_second_activity)
        btn.setOnClickListener {
            val intent = Intent(this@FirstActivity,SecondActivity::class.java)
            startActivity(intent) }
    }
}