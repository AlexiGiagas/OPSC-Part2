package com.example.opsc_part2


import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.TimePicker
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


        val display = findViewById<TextView>(R.id.txtEndDisp)
        val tp = findViewById<TimePicker>(R.id.tpStart)
        tp.setOnTimeChangedListener { _, hour, minute ->

        //region StartTime
        val startdisplay = findViewById<TextView>(R.id.txtStartDisp)
        val tpstart = findViewById<TimePicker>(R.id.tpStart)
        tpstart.setOnTimeChangedListener { _, hour, minute ->

            var hour = hour
            var am_pm = ""
            // AM_PM decider logic
            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM" }

                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM" }

                else -> am_pm = "AM"
            }
            if (startdisplay != null)
            {
                val hour = if (hour < 10) "0" + hour else hour
                val min = if (minute < 10) "0"  + minute else minute
                // display format of time
                val msg = "Time is: $hour : $min $am_pm"
                startdisplay.text = msg
                startdisplay.visibility = ViewGroup.VISIBLE
            }
        }
        //endregion


        var btnadd : Button = findViewById(R.id.btnAddTimesheet)

        var tdate : EditText = findViewById(R.id.txtDate)
        var desc : EditText = findViewById(R.id.txtDescription)

        btnadd.setOnClickListener()
        {

            if((startdisplay.text.toString().isEmpty()) || (desc.text.toString().isEmpty()))
            {
                Toast.makeText(this, "Please enter all fields!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                arrTimesheet.add(TimesheetData(startdisplay.text.toString(), desc.text.toString()))
                Toast.makeText(this, "Added to array", Toast.LENGTH_SHORT).show()
                arrTimesheet.isEmpty()
            }

        }
    }
}