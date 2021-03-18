package com.example.bookexchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_profile.pro_bottom_nav
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.display_book.view.*

var user:String?=null
val firestore = FirebaseFirestore.getInstance()


class search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        user = intent.getStringExtra("user").toString()

//         navigation
        pro_bottom_nav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.btn_nav_home -> {
                        val intent = Intent(this@search, profile::class.java)
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                }
                return@OnNavigationItemSelectedListener true
            }
        )
//        Search and display book from firebse
        firestore.collection("users").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.getResult()!!) {
                        if (document.id != user) {
                            firestore.collection("users").document(document.id!!)
                                .collection("Book Details").get()
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful()) {
                                        for (document in task.getResult()!!) {
                                            textView3.setText(document.get("Book Name").toString())
                                        }
                                    }
                                }
                        } else {
                        }
//                        textView3.setText(userName[0])
                    }
                }
            }

    }
}