package com.example.movieapp0

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
       /* signinButton.setOnClickListener {
            val email:String=emailAddressTextView.text.toString()
            val password:String=passwordTextView.text.toString()

            Toast.makeText(this, "Email: $email \nPassword: $password", Toast.LENGTH_LONG).show()

            Log.d("buttonClick", "Email:  $email Password $password")

        } */
    }
    private fun initUi() {
        signinButton.setOnClickListener{
            val email=emailAddressTextView.text.toString()
            val password=passwordTextView.text.toString()
            saveUser(email, password)
            navigateDateailActivity()
        }

    }
    private fun navigateDateailActivity(){
        val detailIntent=Intent(this,MovieDetailActivity::class.java)
        startActivity(detailIntent)
    }
    private fun saveUser(email: String, password: String){
        val preferences : SharedPreferences = getSharedPreferences("MovieApp", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()

        val savedEmail=preferences.getString("email", "default, text")

        Toast.makeText(this, "User saved: Email= $savedEmail", Toast.LENGTH_SHORT).show()
    }
}
