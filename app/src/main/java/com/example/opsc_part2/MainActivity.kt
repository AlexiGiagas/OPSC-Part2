package com.example.opsc_part2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnlogin : Button = findViewById(R.id.btnLogin)
        var btnregister : Button = findViewById(R.id.btnRegister)
        var btngoogle : Button = findViewById(R.id.btnGoogleLogin)

        btnlogin.setOnClickListener()
        {
            var txtUserLog : EditText = findViewById(R.id.txtUsername)
            var txtPassLog : EditText = findViewById(R.id.txtPassword)

            if((txtUserLog.text.toString().isEmpty()) || (txtPassLog.text.toString().isEmpty()))
            {
                Toast.makeText(this, "Please enter valid Username and Password",Toast.LENGTH_LONG).show()
            }
            else
            {

            }

        }

        btnregister.setOnClickListener()
        {

        }

        btngoogle.setOnClickListener()
        {

        }

    }
}