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

        // 좋은말
        Good_Writing()

        // 격리 시작 버튼
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
        val write = listOf("네가 힘들고 우울하고 지칠때는 너를 아끼는 사람을 생각하자 ", "무적인 사람은 어디에도 없다 다 속으로 이겨내고 사는것뿐이다 ",
            "물살에 휩쓸리지 않고 벼텨낸다면 그 또한 지나간다 ", "의지만 있으면 얼마든지 극복할 수 있다 ")

        var random = Random().nextInt(write.size)
        var random_write = write[random]
        Good_Writing.setText(""+random_write)
    }

}
