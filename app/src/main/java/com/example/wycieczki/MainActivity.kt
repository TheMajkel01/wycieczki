package com.example.wycieczki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

fun parseDate(date: String): Long {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val parsedDate = formatter.parse(date)
    return parsedDate.time
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val destinationEditText = findViewById<EditText>(R.id.destination)
        val notesEditText = findViewById<EditText>(R.id.notes)

        data class Trip(val id: Long, val startDate: Long, val endDate: Long, val tripTime: Long, val destination: String, val notes: String)

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = "$year-${month + 1}-$dayOfMonth"

            if (findViewById<TextView>(R.id.startDateTextView).text.isEmpty()) {
                findViewById<TextView>(R.id.startDateTextView).text = selectedDate
            } else if (findViewById<TextView>(R.id.endDateTextView).text.isEmpty()) {
                findViewById<TextView>(R.id.endDateTextView).text = selectedDate
            }
        }

        findViewById<Button>(R.id.reset).setOnClickListener {
            findViewById<TextView>(R.id.startDateTextView).text = ""
            findViewById<TextView>(R.id.endDateTextView).text = ""
            findViewById<EditText>(R.id.destination).text.clear()
            findViewById<EditText>(R.id.notes).text.clear()
        }
    }
}