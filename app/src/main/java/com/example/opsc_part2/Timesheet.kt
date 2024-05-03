package com.example.opsc_part2


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.regex.Pattern

class Timesheet : AppCompatActivity()
{

    //Companion object that stores the timesheet arraylist
    companion object {
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

        //Declaring variables for the start and end dates
        val startdisplay = findViewById<TextView>(R.id.txtStartDisp)
        val enddisplay = findViewById<TextView>(R.id.txtEndDisp)

        startdisplay.visibility = View.GONE
        enddisplay.visibility = View.GONE

        //Code for the start time
        val tp = findViewById<TimePicker>(R.id.tpStart)
        tp.setOnTimeChangedListener { _, hour, minute ->
            val startdisplay = findViewById<TextView>(R.id.txtStartDisp)
            val tpstart = findViewById<TimePicker>(R.id.tpStart)
            tpstart.setOnTimeChangedListener { _, hour, minute ->

                var hour = hour
                var am_pm = ""
                // AM_PM decider logic
                when {
                    hour == 0 -> {
                        hour += 12
                        am_pm = "AM"
                    }

                    hour == 12 -> am_pm = "PM"
                    hour > 12 -> {
                        hour -= 12
                        am_pm = "PM"
                    }

                    else -> am_pm = "AM"
                }
                if (startdisplay != null) {
                    val hour = if (hour < 10) "0" + hour else hour
                    val min = if (minute < 10) "0" + minute else minute
                    // display format of time
                    val msg = "$hour : $min $am_pm"
                    startdisplay.text = msg
                }
            }

            //Code for the end time
            val enddisplay = findViewById<TextView>(R.id.txtEndDisp)
            val tpend = findViewById<TimePicker>(R.id.tpEnd)
            tpend.setOnTimeChangedListener { _, hour, minute ->
                var hour = hour
                var am_pm = ""
                // AM_PM decider logic
                when {
                    hour == 0 -> {
                        hour += 12
                        am_pm = "AM"
                    }

                    hour == 12 -> am_pm = "PM"
                    hour > 12 -> {
                        hour -= 12
                        am_pm = "PM"
                    }

                    else -> am_pm = "AM"
                }
                if (enddisplay != null) {
                    val hour = if (hour < 10) "0" + hour else hour
                    val min = if (minute < 10) "0" + minute else minute
                    // display format of time
                    val message = "$hour : $min $am_pm"
                    enddisplay.text = message
                }
            }

            //Code block below for the adding of dates and times to the timesheet
            var btnadd: Button = findViewById(R.id.btnAddTimesheet)
            btnadd.setOnClickListener()
            {

                val dateString: EditText = findViewById(R.id.txtDate)
                val desc: EditText = findViewById(R.id.txtDescription)

                val pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}")
                val matcher = pattern.matcher(dateString.text.toString())

                //error handling
                if ((startdisplay.text.toString().isEmpty()) || (enddisplay.text.toString()
                        .isEmpty()) || (desc.text.toString().isEmpty()) || (dateString.text.toString().isEmpty())
                ) {
                    Toast.makeText(this, "Enter all fields!", Toast.LENGTH_SHORT).show()
                }
                else if (!matcher.matches()) {
                    dateString.error = "Please make sure the date is in the format: dd-mm-yyyy"
                }
                else {
                    val formatter = SimpleDateFormat("dd-MM-yyyy")
                    val date = formatter.parse(dateString.text.toString())
                    val formateddate = formatter.format(date)
                    arrTimesheet.add(TimesheetData(date, startdisplay.text.toString(), enddisplay.text.toString(), desc.text.toString()))
                    Toast.makeText(this, "Successfully added timesheet", Toast.LENGTH_SHORT).show()
                }


            }
        }

        //back button on timesheet page
        var back : Button = findViewById(R.id.btnBack)
        back.setOnClickListener() {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}
