package com.example.opsc_part2


import java.util.Date

//Data class to create template for Timesheet ArrayList
data class TimesheetData (
    val Date : Date,
    val StartTime : String,
    val EndTime : String,
    val Description : String
)
