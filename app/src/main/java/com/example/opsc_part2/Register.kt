package com.example.opsc_part2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        var btnReg : Button = findViewById(R.id.btnRegister)

        btnReg.setOnClickListener() {
            var uname: EditText = findViewById(R.id.txtUserReg)
            var pass: EditText = findViewById(R.id.txtPassReg)

            if ((uname.text.toString().equals("")) || (pass.text.toString().equals(""))) {
                //error
            }
            else {
                MainActivity.arrUsers.add(Users(uname.text.toString(), pass.text.toString()))
            }
        }

    }
}