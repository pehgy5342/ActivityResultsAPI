package com.example.activityresultsapi

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val msg = findViewById<TextView>(R.id.tv_msg)
        val back = findViewById<Button>(R.id.btn_back)
        val back_msg = findViewById<Button>(R.id.btn_msg)

        val str = intent.getStringExtra("one")

        msg.text = str

        back.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                finish()
            })
        }

        back_msg.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra("one", "一")
            })
            finish()
        }
    }
}