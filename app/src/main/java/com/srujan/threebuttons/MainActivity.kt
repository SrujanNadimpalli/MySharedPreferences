package com.srujan.threebuttons

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.TextView
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {

    lateinit private var sharedPreferences: SharedPreferences
    lateinit private var name: TextView
    lateinit private var email: TextView
    val mypreference = "mypref"
    val Name = "namekey"
    val Email = "emailKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name=findViewById(R.id.input)
        email = findViewById(R.id.input1)
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
    }

    fun save(view: View?) {

        val n = name.text.toString()
        val e = email.text.toString()
        val editor = sharedPreferences.edit()
        editor.putString(Name, n)
        editor.putString(Email, e)
        editor.apply()
    }

    fun clear(view: View?) {
        name.text = ""
        email.text = ""
    }

    fun get(view: View) {

        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        name.text = sharedPreferences.getString(Name, "")
        email.text = sharedPreferences.getString(Email, "")
    }
}




