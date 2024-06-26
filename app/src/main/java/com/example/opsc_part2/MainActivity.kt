package com.example.opsc_part2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object
    {
        var arrUsers = ArrayList<Users>()
        var SignedIn : Int = 0

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Declaring variables
        var btnregister : Button = findViewById(R.id.btnRegister)
        //var btngoogle : Button = findViewById(R.id.btnGoogleLogin)


        var username : EditText = findViewById(R.id.txtUsername)
        var password : EditText = findViewById(R.id.txtPass)


        arrUsers.add(Users("John", "12345"))
        arrUsers.add(Users("Jane","54321"))

        //Login button
        var btnlogin : Button = findViewById(R.id.btnLogin)
        btnlogin.setOnClickListener()
        {
            var found = false
            SignedIn = -1

            for(i in 0 until arrUsers.size)
            {
                //error handling
                if((username.text.toString().equals(arrUsers[i].Username)) && (password.text.toString().equals(arrUsers[i].Password)))
                {
                    Toast.makeText(this, "Successfully logged in!", Toast.LENGTH_SHORT).show()

                    found = true

                    val int = Intent(this, Home::class.java)
                    startActivity(int)
                    SignedIn = i
                    break
                }
            }
            if(found == false)
            {
                username.setError("Please enter valid username!")
                password.setError("Please enter valid password!")
            }

        }

        //register button
        btnregister.setOnClickListener()
        {
            val n = Intent(this, Register::class.java)
            startActivity(n)
        }



    }
}