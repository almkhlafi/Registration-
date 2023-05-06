package com.example.registaration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_info)
        var ffname=findViewById<TextView>(R.id.fullName)
        var email=findViewById<TextView>(R.id.email)
        var pwd=findViewById<TextView>(R.id.pwd)
        var gender=findViewById<TextView>(R.id.gender)
        var hobbies=findViewById<TextView>(R.id.Hobbies)
        val emaill=intent.getStringExtra("Email")
        val pwdd=intent.getStringExtra("pwd")

        //Implicit assignment
        email.text="Email :"+emaill
        pwd.text="Password :"+pwdd
        //Explicit assignment
        ffname.text="Name & Surname : "+intent.getStringExtra("fullname")
        gender.text="Gender :"+intent.getStringExtra("Gender")
        hobbies.text="Hobbies: \n \n "+intent.getStringExtra("Hobbies")

    }
    override fun onBackPressed() {
        val intent = Intent(this,Registrarion::class.java)
        startActivity(intent)
        finish()
    }

}