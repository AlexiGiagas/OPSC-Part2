package com.example.opsc_part2

import java.sql.Time
import java.util.Date

data class TimesheetData (
    val Date : Date,
    val StartTime : Time,
    val EndTime : Time,
    val Description : String,
    //val imageURL : String
)
//Double check if this is fine!!