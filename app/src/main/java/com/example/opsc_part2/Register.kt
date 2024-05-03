package com.example.opsc_part2

import android.content.Intent
import android.os.Bundle
import android.sax.StartElementListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Registration button on register page
        var btnReg : Button = findViewById(R.id.btnRegister)
        btnReg.setOnClickListener() {
            var uname: EditText = findViewById(R.id.txtUserReg)
            var pass: EditText = findViewById(R.id.txtPassReg)

            //error handling
            if ((uname.text.toString().equals("")) || (pass.text.toString().equals(""))) {
                uname.setError("Please enter valid username!")
                pass.setError("Please enter valid password!")
            }
            else {
                MainActivity.arrUsers.add(Users(uname.text.toString(), pass.text.toString()))
                Toast.makeText(this, "Successfully registered! Please login.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}