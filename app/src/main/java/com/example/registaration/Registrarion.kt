package com.example.registaration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class Registrarion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        var name = findViewById<EditText>(R.id.Tname)
        var Email = findViewById<EditText>(R.id.TEmail)
        var pwd = findViewById<EditText>(R.id.Tpwd)
        var cpwd = findViewById<EditText>(R.id.Tcpwd)
        var male = findViewById<RadioButton>(R.id.Male)
        var female = findViewById<RadioButton>(R.id.Female)
        var coding = findViewById<CheckBox>(R.id.Coding)
        var videogames = findViewById<CheckBox>(R.id.VideoGames)
        var boxing = findViewById<CheckBox>(R.id.Boxing)
        var driving = findViewById<CheckBox>(R.id.Driving)
        var gym = findViewById<CheckBox>(R.id.Gym)
        var swimming = findViewById<CheckBox>(R.id.Swimming)
        var bConfirm = findViewById<Button>(R.id.bConfirm)
        var bClear = findViewById<Button>(R.id.bClear)

        bConfirm.setOnClickListener {
            Intent(this, ShowInfo::class.java).also {
                if (pwd.text.isNullOrEmpty() && cpwd.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Password field is empty", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                } else if (pwd.text.toString() != cpwd.text.toString()) {
                    Toast.makeText(this, "Passwords not matching", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                //pass name and password
                it.putExtra("fullname", name.text.toString())
                it.putExtra("Email", Email.text.toString())
                it.putExtra("pwd", pwd.text.toString())

                var Gender = ""
                if (male.isChecked){
                    Gender = "Male"
                }
                else if (female.isChecked){
                    Gender = "Female"
                }
                else {
                    ///use this to make validation for==> this@Registrarion then wher use return@Registrarion
                    Toast.makeText(
                        this@Registrarion,
                        "Chose Your Gender pls",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                it.putExtra("Gender", Gender)

                var hobby = ""
                if (driving.isChecked)
                    hobby += driving.text.toString() + "\n\t"
                if (swimming.isChecked)
                    hobby += swimming.text.toString() + "\n\t"
                if (gym.isChecked)
                    hobby += gym.text.toString() + "\n\t"
                if (coding.isChecked)
                    hobby += coding.text.toString() + "\n\t"
                if (videogames.isChecked)
                    hobby += videogames.text.toString() + "\n\t"
                if (boxing.isChecked)
                    hobby += boxing.text.toString() + "\n\t"
                if (hobby.isNullOrEmpty()) {
                    Toast.makeText(this@Registrarion, "Chose at least one Hobby !!", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }
                it.putExtra("Hobbies", hobby)
                startActivity(it)
            }


            Intent(this,Login::class.java).also {
                if (pwd.text.isNullOrEmpty() && cpwd.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Password field is empty", Toast.LENGTH_SHORT).show()
                    return@also
                } else if (pwd.text.toString() != cpwd.text.toString()) {
                    Toast.makeText(this, "Passwords not matching", Toast.LENGTH_SHORT).show()
                    return@also
                }
                it.putExtra("Email", Email.text.toString())
                it.putExtra("pwd", pwd.text.toString())
                startActivity(it)
                finish()

            }

        }
        bClear.setOnClickListener(){
            name.setText("")
            Email.setText("")
            pwd.setText("")
            cpwd.setText("")
            male.isChecked=false
            female.isChecked=false
            coding.isChecked=false
            videogames.isChecked=false
            boxing.isChecked=false
            driving.isChecked=false
            gym.isChecked=false
            swimming.isChecked=false
        }
    }
}

