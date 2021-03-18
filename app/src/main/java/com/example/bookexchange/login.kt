package com.example.bookexchange

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import kotlinx.android.synthetic.main.activity_login.*


class login : AppCompatActivity() {
//    variable declearation
    private lateinit var userid:String
    private lateinit var psw:String
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth

//      redirect to profile after login
        lgn_btn_login.setOnClickListener(View.OnClickListener {
//          Validation of user id and password
            userid=lgn_et_id.text.toString().trim()
            psw=lgn_et_psw.text.toString()
                if(userid.isEmpty() && psw.isEmpty()){
                        lgn_et_id.setError("Field can't be empty")
                        lgn_et_psw.setError("Field can't be empty")
                    }
                else if ( psw.isEmpty()){
                        lgn_et_psw.setError("Field can't be empty")
                    }
                else if ( userid.isEmpty()){
                    lgn_et_id.setError("Field can't be empty")
                    }
                else{
                    auth.signInWithEmailAndPassword(userid, psw)
                            .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "signInWithEmail:success")
                                val user = auth.currentUser
                                var intent1=Intent(this@login, profile::class.java)
                                intent1.putExtra("user",userid)
                                startActivity(intent1)
                                finish()
                                Toast.makeText(baseContext, "Authentication successful.",Toast.LENGTH_SHORT).show()
                            } else{
                                Log.w("TAG", "signInWithEmail:failure", task.exception)
                                val builder = AlertDialog.Builder(this)
                                builder.setMessage("Invalid User id and Password")
                                builder.setTitle("Error")
                                builder.setCancelable(false)
                                builder.setNegativeButton("OK") { dialog, which -> dialog.cancel()
                                }
                                val alertDialog = builder.create()
                                alertDialog.show()
                                Toast.makeText(baseContext, "Authentication Failed.",Toast.LENGTH_SHORT).show()
                            }
                        }

                }
        })

//        redirect to registration after click on sing up
        lgn_txt_signup.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@login, password_Set::class.java)
            startActivity(intent)
            finish()
        })
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
//            reload();
        }
    }
}