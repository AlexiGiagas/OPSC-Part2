package com.example.opsc_part2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.regex.Pattern

class ListOfEntries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_of_entries)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnSearch: Button = findViewById(R.id.btnSearchEntries)
        btnSearch.setOnClickListener() {
            val startdate: TextView = findViewById(R.id.txtStartDate)
            val enddate: TextView = findViewById(R.id.txtEndDate)

            val pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}")
            val matcher1 = pattern.matcher(startdate.text.toString())
            val matcher2 = pattern.matcher(enddate.text.toString())

            if ((matcher1.matches()) && (matcher2.matches())) {
                val formatter = SimpleDateFormat("dd-MM-yyyy")
                for (arg in Timesheet.arrTimesheet) {
                    val date = formatter.format(arg.Date)

                    val temp1 = formatter.parse(startdate.text.toString())
                    val sdate = formatter.format(temp1)
                    val temp2 = formatter.parse(enddate.text.toString())
                    val edate = formatter.format(temp2)

                    if ((date >= sdate) && (date <= edate)) {
                        Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


        var back: Button = findViewById(R.id.btnBack)
        back.setOnClickListener() {

            //Declaring bac button variable
            var back: Button = findViewById(R.id.btnBack)

            //Setting an on click event to go to the home page
            back.setOnClickListener()
            {

                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }


            //Declaring variables
            val startdate: TextView = findViewById(R.id.txtStartDate)
            val enddate: TextView = findViewById(R.id.txtEndDate)
            val pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}")
            val matcher1 = pattern.matcher(startdate.text.toString())
            val matcher2 = pattern.matcher(enddate.text.toString())

            if ((matcher1.matches()) && (matcher2.matches())) {
                val formatter = SimpleDateFormat("dd-MM-yyyy")
                for (arg in Timesheet.arrTimesheet) {
                    val date = formatter.format(arg.Date)
                    val temp1 = formatter.parse(startdate.text.toString())
                    val sdate = formatter.format(temp1)
                    val temp2 = formatter.parse(enddate.text.toString())
                    val edate = formatter.format(temp2)

                    if ((date >= sdate) && (date <= edate)) {
                        Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}