package com.example.adopcionmascotas.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast

import com.example.adopcionmascotas.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {
    internal lateinit var mService : ApiServiceUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mService = Common.api
        btn_register.setOnClickListener{
            createNewUser(name.text.toString(),email.text.toString(),password.text.toString())
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }




    }
    private fun createNewUser(name: String,email:String,password:String){
        mService.registerUser(name,email,password)
            .enqueue(object : Callback<APIResponse> {
                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                    if (response!!.body()!!.error)
                        Toast.makeText(
                            this@RegisterActivity,
                            response.body()!!.error_msg,
                            Toast.LENGTH_SHORT
                        ).show()
                    else {
                        Toast.makeText(this@RegisterActivity, "Registrado!!"+response.body()!!.uid, Toast.LENGTH_SHORT).show()

                        finish()
                }



            }

                override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity,t!!.message,Toast.LENGTH_SHORT).show()
                }
            })

    }

}