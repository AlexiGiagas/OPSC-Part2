package com.example.opsc_part2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView

class Categories : AppCompatActivity()
{
    //Declaring the category arraylist
    var arrCategories = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_categories)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declaring variables
        var btnaddcategory : Button = findViewById(R.id.btnAddCategory)
        var listbox : ListView = findViewById(R.id.listBox)
        var back : Button = findViewById(R.id.btnBack)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrCategories)

        //Creating an adapter
        listbox.adapter = adapter

        //Setting an on click event for the add category button
        btnaddcategory.setOnClickListener()
        {
            var categ : EditText = findViewById(R.id.txtCategory)

            //Error handling
            if (categ.text.toString().equals(""))
            {
                categ.setError("Please enter valid Category!")
            }

            //Adding the category to the array
            else
            {
                arrCategories.add(categ.text.toString())
                Toast.makeText(this, "Successfully added Category.", Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
            }
        }

        //Setting an on click event for the back button to go to the main menu
        back.setOnClickListener() {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}