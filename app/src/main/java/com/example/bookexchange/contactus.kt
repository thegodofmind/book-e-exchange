package com.example.bookexchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_contactus.*

class contactus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactus)

        intent=intent
        val user = intent.getStringExtra("user").toString()

//      Next Botton
        contact_btn_next.setOnClickListener(View.OnClickListener {
            var intent= Intent(this@contactus,profile::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
            finish()
        })
    }
}