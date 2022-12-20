package com.example.wycieczki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)


    }
}