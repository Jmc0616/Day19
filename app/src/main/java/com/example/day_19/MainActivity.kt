package com.example.day_19

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_date.setOnClickListener{
            showDatePicker()
        }
    }
    fun showDatePicker(){
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{datePicker, year, month, day ->
            println(year)
            println(month + 1)
            println(day)
        }, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE)).show();
    }
}