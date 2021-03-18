package com.example.bookexchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_privacy.*

class privacy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)

        intent=intent
        val user = intent.getStringExtra("user").toString()

//      Cancel botton
        cp_btn_cancel.setOnClickListener(View.OnClickListener {
            var intent= Intent(this@privacy,profile::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
            finish()
        })

//      Send Botton
        cp_btn_save.setOnClickListener(View.OnClickListener {
            var intent= Intent(this@privacy,profile::class.java)
            intent.putExtra("user", user)
            Toast.makeText(applicationContext, "Your password has been changed.", Toast.LENGTH_LONG).show()
            startActivity(intent)
            finish()
        })
    }
}