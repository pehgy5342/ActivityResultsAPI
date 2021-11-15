package com.example.activityresultsapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val msg = findViewById<TextView>(R.id.tv_msg)
        val go = findViewById<Button>(R.id.btn_intent)

        val toActivity2Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                result.data?.getStringExtra("one").let {
                    msg.text = it
                }
            }
        go.setOnClickListener {
            toActivity2Launcher.launch(Intent(this, MainActivity2::class.java).apply {
                putExtra("one", "一")
            })
        }
    }
}