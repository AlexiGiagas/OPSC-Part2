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

class MinMaxHours : AppCompatActivity()
{
    companion object
    {
<<<<<<< Updated upstream
        var arrMinMax : ArrayList<String> = ArrayList()
=======
        //var arrMinMax : Array<Int>()
>>>>>>> Stashed changes
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_min_max_hours)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnaddminmax : Button = findViewById(R.id.btnAddMinMaxHours)
        var min : EditText = findViewById(R.id.txtMinHours)
        var max : EditText = findViewById(R.id.txtMaxHours)


        btnaddminmax.setOnClickListener()
        {
            if((min.text.toString().isEmpty()) || (max.text.toString().isEmpty()))
            {
                min.setError("Please enter valid minimum hours")
                max.setError("Please enter valid maximum hours")
            }
            else
            {
                println(arrMinMax.isEmpty())
                arrMinMax.add(min.text.toString())
                arrMinMax.add(max.text.toString())
                println(arrMinMax.isEmpty())

                Toast.makeText(this, "Successfully added Min and Max hours", Toast.LENGTH_SHORT).show()
            }
        }

        var back : Button = findViewById(R.id.btnBack)

        back.setOnClickListener() {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}