package com.example.day_19

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    var cal = Calendar.getInstance()
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH)
    val day = cal.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 현재 날짜
        var now = LocalDate.now()
        var formatDate = DateTimeFormatter.ISO_DATE
        var nowDate = now.format(formatDate)
        now_date_detail.setText(""+ now)

        date_button.setOnClickListener{
            endDatePicker()
            startDatePicker()
        }
    }

    fun startDatePicker(){
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{datePicker, year, month, day ->
            start_date_detail.setText(""+year+month+day)

            var Dday = Calendar.getInstance()
            Dday.set(year, month, day)
            var today = Calendar.getInstance()

            var DDay = Dday.timeInMillis / 86400000
            var ToDay = today.timeInMillis / 86400000

            var D_day = ToDay-DDay

            start_date.setText(""+D_day)

        }, year, month, day).show()

    }
    fun endDatePicker(){
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{datePicker, year, month, day ->
            end_date_detail.setText(""+year+month+day)

            var Dday = Calendar.getInstance()
            Dday.set(year, month, day)
            var today = Calendar.getInstance()

            var DDay = Dday.timeInMillis / 86400000
            var ToDay = today.timeInMillis / 86400000

            var D_day = DDay-ToDay
            end_date.setText(""+D_day)

        }, year, month, day).show()
    }
    fun Good_Writing(){
        
    }

}
