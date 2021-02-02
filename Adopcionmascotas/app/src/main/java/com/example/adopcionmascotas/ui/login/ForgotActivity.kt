package com.example.adopcionmascotas.ui.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText

import com.example.adopcionmascotas.R
import kotlinx.android.synthetic.main.activity_forgot.*


class ForgotActivity : AppCompatActivity() {
    private var email: EditText? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
        btnSend.setOnClickListener{ startActivity(Intent(this@ForgotActivity, LoginActivity::class.java))}
    }


    private fun action() {
        val intent = Intent(this@ForgotActivity, LoginActivity::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }
}
