package com.driuft.androidkotlindebugging.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.driuft.androidkotlindebugging.R
import java.util.*

class CurrentDayActivity : AppCompatActivity() {

    private lateinit var currentDayText: TextView
    private val cal: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_day)

        currentDayText = findViewById(R.id.current_day_text)
        //currentDayText.text = getString(getDayOfMonth())
        // getString() is expecting a string but getDayOfMonth() is returning an Int
        // getString() is not needed - just need getDayOfMonth() and convert to string
        //currentDayText.text = getDayOfMonth().toString()
        currentDayText.text = "${getMonth()}/${getDayOfMonth()}/${getYear()}"
    }

    private fun getDayOfMonth(): Int {
        return cal.get(Calendar.DAY_OF_MONTH)
    }

    private fun getMonth():Int {
        //months start from 0 so adding 1 to reflect actual month
        return cal.get(Calendar.MONTH) + 1
    }

    private fun getYear(): Int {
        //current year
        return cal.get(Calendar.YEAR)
    }
}