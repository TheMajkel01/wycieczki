package com.example.wycieczki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun parseDate(date: String): Long {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val parsedDate = formatter.parse(date)
    return parsedDate.time
}

fun convertMillisecondsToDays(milliseconds: Long): Long {
    return TimeUnit.MILLISECONDS.toDays(milliseconds)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.startDateTextView).text=""
        findViewById<TextView>(R.id.endDateTextView).text=""
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val destinationEditText = findViewById<EditText>(R.id.destination)
        val notesEditText = findViewById<EditText>(R.id.notes)
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val calendar = Calendar.getInstance()
        val currentDate = calendar.time
        val formattedDate = formatter.format(currentDate)

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = "$year-${month + 1}-$dayOfMonth"

            if (findViewById<TextView>(R.id.startDateTextView).text.isEmpty()) {
                findViewById<TextView>(R.id.startDateTextView).text = selectedDate
            } else if (findViewById<TextView>(R.id.endDateTextView).text.isEmpty()) {
                findViewById<TextView>(R.id.endDateTextView).text = selectedDate
            }

        }

        findViewById<Button>(R.id.submit_button).setOnClickListener {
            if (parseDate(formattedDate.toString()) > parseDate(findViewById<TextView>(R.id.startDateTextView).text.toString())){
                findViewById<TextView>(R.id.error).setTextColor(-0x10000)
                findViewById<TextView>(R.id.error).text="Trip date in the past!"
            }
            else{
                findViewById<TextView>(R.id.error).setTextColor(resources.getColor(R.color.white))
                var time = parseDate(findViewById<TextView>(R.id.endDateTextView).text.toString()) - parseDate(findViewById<TextView>(R.id.startDateTextView).text.toString())
                findViewById<TextView>(R.id.error).text=(convertMillisecondsToDays(time)).toString()
            }
        }


        findViewById<Button>(R.id.reset).setOnClickListener {
            findViewById<TextView>(R.id.startDateTextView).text = ""
            findViewById<TextView>(R.id.endDateTextView).text = ""
            findViewById<EditText>(R.id.destination).text.clear()
            findViewById<EditText>(R.id.notes).text.clear()
            findViewById<TextView>(R.id.error).text = ""
        }
    }
}