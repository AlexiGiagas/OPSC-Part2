package com.example.opsc_part2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
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

    //Declaring local array
    var arrEntries = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_of_entries)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listbox : ListView = findViewById(R.id.lstEntry)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrEntries)
        listbox.adapter = adapter

        //Resetting listview
        arrEntries.clear()
        adapter.notifyDataSetChanged()

        //Declaring bac button variable
        var back: Button = findViewById(R.id.btnBack)

        //Setting an on click event to go to the home page
        back.setOnClickListener()
        {

            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        var search: Button = findViewById(R.id.btnSearchEntries)
        search.setOnClickListener()
        {
            //Resetting listview
            arrEntries.clear()
            adapter.notifyDataSetChanged()

            //Declaring variables
            val startdate: TextView = findViewById(R.id.txtStartDate)
            val enddate: TextView = findViewById(R.id.txtEndDate)
            val pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}")
            val matcher1 = pattern.matcher(startdate.text.toString())
            val matcher2 = pattern.matcher(enddate.text.toString())

            if ((matcher1.matches()) && (matcher2.matches())) {
                val formatter = SimpleDateFormat("dd-MM-yyyy")
                val sdate = formatter.parse(startdate.text.toString())
                val edate = formatter.parse(enddate.text.toString())

                for (arg in Timesheet.arrTimesheet) {
                    val date = formatter.parse(formatter.format(arg.Date))

                    if (date in sdate..edate) {
                        val formateddate = formatter.format(arg.Date)
                        arrEntries.add("Date: " + formateddate + ", Start Time: " + arg.StartTime + ", End Time: " + arg.EndTime + ", Desc: " + arg.Description)

                        adapter.notifyDataSetChanged()
                    }
                }
            }
            else
            {
                startdate.error = "Please make sure the date is in the format: dd-mm-yyyy"
                enddate.error = "Please make sure the date is in the format: dd-mm-yyyy"
            }
        }


    }
}