package com.example.opsc_part2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MinMaxHours : AppCompatActivity()
{
    companion object
    {
        var arrMinMax : Array<Int>()
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
                min.setError("Please enter minimum daily hours")
                max.setError("Please enter maximum daily hours")
            }
            else
            {

            }
        }
    }
}