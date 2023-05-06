package com.example.registaration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var email=findViewById<EditText>(R.id.Email)
        var pwd=findViewById<EditText>(R.id.pwd)
        var Login=findViewById<Button>(R.id.bLogin)
        var clear=findViewById<Button>(R.id.bClear)
        val pwdd=intent.getStringExtra("pwd")
        val emaill=intent.getStringExtra("Email")
        Login.setOnClickListener(){
            if(pwdd.toString()==pwd.text.toString() && (!email.text.toString().isNullOrEmpty() || !pwd.text.toString().isNullOrEmpty()) && (email.text.toString()==emaill.toString())){
                Toast.makeText(this@Login, "Correct Password", Toast.LENGTH_SHORT).show();
                finish()
            }
            else
                Toast.makeText(this@Login, "Incorrect Email Or Password", Toast.LENGTH_SHORT).show();
        }

        clear.setOnClickListener(){
            pwd.setText("")
            email.setText("")
        }

    }
    //To overRide BackPressed to the wanted activity
    override fun onBackPressed() {
        val intent = Intent(this,Registrarion::class.java)
        startActivity(intent)
        finish()
    }

}