package com.example.opsc_part2


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Date

class Timesheet : AppCompatActivity() {

    companion object
    {
        var arrTimesheet = ArrayList<TimesheetData>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_timesheet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnadd : Button = findViewById(R.id.btnAddTimesheet)

        var tdate : EditText = findViewById(R.id.txtDate)
        var tstart : EditText = findViewById(R.id.txtStartTime)
        var tend : EditText = findViewById(R.id.txtEndTime)
        var desc : EditText = findViewById(R.id.txtDescription)

        btnadd.setOnClickListener()
        {

            if((tdate.text.toString().isEmpty()) || (tstart.text.toString().isEmpty()) || (tend.text.toString().isEmpty()) || (desc.text.toString().isEmpty()))
            {
                Toast.makeText(this, "Please enter all fields!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                
            }

        }
    }
}