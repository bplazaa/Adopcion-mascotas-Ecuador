package com.example.adopcionmascotas.ui.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.adopcionmascotas.MainActivity
import com.example.adopcionmascotas.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response



class LoginActivity : AppCompatActivity() {
    internal lateinit var mService : ApiServiceUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //inicio  de servicios
        mService = Common.api
    //event
        tvRegistrar.setOnClickListener{ startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))}
        tvForgotPass.setOnClickListener{ startActivity(Intent(this@LoginActivity, ForgotActivity::class.java))}
        btn_login.setOnClickListener{ startActivity(Intent(this@LoginActivity, MainActivity::class.java))}






    }
/*
    private  fun authenticateUser(email:String, password:String){
        mService.loginUser(email,password)
            .enqueue(object : Callback<APIResponse>{
                override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity,t!!.message,Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                    if (response!!.body()!!.error){
                        Toast.makeText(this@LoginActivity,response!!.body()!!.error_msg,Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(this@LoginActivity, "Logeado!!", Toast.LENGTH_SHORT).show()

                    }
                }
            })

    }*/

}