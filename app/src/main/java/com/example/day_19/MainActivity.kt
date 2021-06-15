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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 현재 날짜
        val now = LocalDate.now()
        val formatDate = DateTimeFormatter.ISO_DATE
        val nowDate = now.format(formatDate)
        now_date_detail.setText(""+ now)

        // 격리 시작일
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        date_button.setOnClickListener {
            var end_day = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->

                    end_date_detail.setText("" + mYear + "년 " + mMonth + "월 " + mDay + "일 ")
                }, year, month, day)

            end_day.show()

            var start_day = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->

                    start_date_detail.setText("" + mYear + "년 " + mMonth + "월 " + mDay + "일 ")
                }, year, month, day)

            start_day.show()
        }
        // var time_count = nowDate - end_date
        // var EndDate = LocalDate.of(start_day)

        // var D_day = Period.between(now, EndDate)

        // start_date.setText(""+D_day.getDays())

    }
}