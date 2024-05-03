package com.example.opsc_part2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView

class Categories : AppCompatActivity()
{
    var arrCategories = ArrayList<CategoriesData>()
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

        var btnaddcategory : Button = findViewById(R.id.btnAddCategory)

        btnaddcategory.setOnClickListener()
        {
            var categ : EditText = findViewById(R.id.txtCategory)

            if (categ.text.toString().equals(""))
            {
                categ.setError("Please enter valid Category!")
            }
            else
            {
                arrCategories.add(CategoriesData(categ.text.toString()))
                Toast.makeText(this, "Successfully added Category.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}