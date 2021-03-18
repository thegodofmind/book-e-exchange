package com.example.bookexchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_feedback.*

class feedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        intent=intent
        val user = intent.getStringExtra("user").toString()

//      Cancel botton
        fb_btn_cancel.setOnClickListener(View.OnClickListener {
            var intent=Intent(this@feedback,profile::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
            finish()
        })

//      Send Botton
        fb_btn_save.setOnClickListener(View.OnClickListener {
            var intent=Intent(this@feedback,profile::class.java)
            intent.putExtra("user", user)
            Toast.makeText(applicationContext, "Thank you for your feedback.", Toast.LENGTH_LONG).show()
            startActivity(intent)
            finish()
        })
    }
}