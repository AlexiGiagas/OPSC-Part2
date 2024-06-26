package com.example.opsc_part2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class Home : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declaring variables
        var timesheet : Button = findViewById(R.id.btnTimesheet)
        var categories : Button = findViewById(R.id.btnCategories)
        var listentries : Button = findViewById(R.id.btnListEntries)
        var tothours : Button = findViewById(R.id.btnTotalHours)
        var minmax : Button = findViewById(R.id.btnMinMax)

        //Setting an on click event to go to the timesheets page
        timesheet.setOnClickListener()
            {
                val t = Intent(this, Timesheet::class.java)
                startActivity(t)
            }

        //Setting an on click event to go to the categories page
        categories.setOnClickListener()
            {
                val c = Intent(this, Categories::class.java)
                startActivity(c)
            }

        //Setting an on click event to go to the list entries page
        listentries.setOnClickListener()
            {
                val le = Intent(this, ListOfEntries::class.java)
                startActivity(le)
            }

        //Setting an on click event to go to the total hours page
        tothours.setOnClickListener()
            {
                val th = Intent(this, TotalHours::class.java)
                startActivity(th)
            }

        //Setting an on click event to go to the min and max hours page
        minmax.setOnClickListener()
            {
                val mm = Intent(this, MinMaxHours::class.java)
                startActivity(mm)
            }
    }
}