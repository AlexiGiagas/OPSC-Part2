package com.example.opsc_part2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Time

class TotalHours : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_total_hours)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var back : Button = findViewById(R.id.btnBack)

        back.setOnClickListener() {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val arrTSdata = ArrayList<String>()

        for (arg in Timesheet.arrTimesheet)
        {
            arrTSdata.add("Date: " + arg.Date + ", Start Time: " + arg.StartTime + ", End Time: " + arg.EndTime + ", Desc: " + arg.Description)
        }

        val listbox : ListView = findViewById(R.id.lstTotalHours)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrTSdata)

    }
}