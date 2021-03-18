package com.example.bookexchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_otp_verification.*

class otp_verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

//      redirect to set id and password after click on verify
        cnf_btn_next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@otp_verification, password_Set::class.java)
            startActivity(intent)
        })

//      redirect to login after click on login
        cnf_txt_login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@otp_verification, login::class.java)
            startActivity(intent)
        })
    }
}