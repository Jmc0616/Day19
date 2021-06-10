package com.example.day_19

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nowdate = LocalDate.now()
        var Str_nowdate = nowdate.format(DateTimeFormatter.ofPattern("yyyy-mm-dd"))


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        date_button.setOnClickListener {
            val start_date = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->

                    start_date_detail.setText("" + mYear + "년 " + mMonth + "월 " + mDay + "일 ")
                }, year, month, day)

            start_date.show()
        }
        // var end_date = c.add(Calendar.DATE,14)
        end_date_detail.setText("${Str_nowdate}")

    }
}