package com.example.wycieczki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val destinationEditText = findViewById<EditText>(R.id.destination)
        val notesEditText = findViewById<EditText>(R.id.notes)

        data class Trip(val id: Long, val startDate: Long, val endDate: Long, val tripTime: Long, val destination: String, val notes: String)
    }
}