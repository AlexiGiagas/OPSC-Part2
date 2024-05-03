package com.example.opsc_part2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.regex.Pattern

class TotalHours : AppCompatActivity()
{

    var arrHours = ArrayList<String>()

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

        val listbox : ListView = findViewById(R.id.lstTotalHours)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrHours)
        listbox.adapter = adapter

        //Resetting listview
        arrHours.clear()
        adapter.notifyDataSetChanged()

        var calchours : Button = findViewById(R.id.btnSearchCategories)
        calchours.setOnClickListener()
        {
            arrHours.clear()
            adapter.notifyDataSetChanged()

            //Declaring variables
            val startdate: TextView = findViewById(R.id.txtStartDate)
            val enddate: TextView = findViewById(R.id.txtEndDate)
            val category : TextView = findViewById(R.id.txtCategorySearch)
            val pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}")
            val matcher1 = pattern.matcher(startdate.text.toString())
            val matcher2 = pattern.matcher(enddate.text.toString())

            var found : Boolean = false
            for (x in Categories.arrCategories)
            {
                if (x.equals(category.text.toString()))
                {
                    found = true
                }
            }

            if ((matcher1.matches()) && (matcher2.matches()) && found) {
                val formatter = SimpleDateFormat("dd-MM-yyyy")
                val sdate = formatter.parse(startdate.text.toString())
                val edate = formatter.parse(enddate.text.toString())

                for (arg in Timesheet.arrTimesheet) {
                    val date = formatter.parse(formatter.format(arg.Date))

                    if (date in sdate..edate) {
                        val formateddate = formatter.format(arg.Date)



                        adapter.notifyDataSetChanged()
                    }
                }
            }
            else
            {
                startdate.error = "Please ensure the date is in the format: dd-mm-yyyy"
                enddate.error = "Please ensure the date is in the format: dd-mm-yyyy"
                category.error = "Please ensure the category already exists and has been added"
            }
        }

    }
}