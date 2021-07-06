package study.component.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}
    private val button3 by lazy {findViewById<Button>(R.id.button3)}
    private val button4 by lazy {findViewById<Button>(R.id.button4)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var builder = AlertDialog.Builder(this)

            builder.setTitle("기본 다이얼로그")
            builder.setMessage("기본 다이얼로그 입니다.")
            builder.setIcon(R.mipmap.ic_launcher)

            builder.setPositiveButton("Positive"){ _, _ ->
                textView.text = "Positive 버튼을 눌렀습니다."
            }

            builder.setNegativeButton("Negative"){ _, _ ->
                textView.text = "Negative 버튼을 눌렀습니다."
            }
            builder.setNeutralButton("Neutral"){ _, _ ->
                textView.text = "Neutral 버튼을 눌렀습니다."
            }

            builder.show()
        }

        button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            val custom_view = layoutInflater.inflate(R.layout.custom_dialog, null)
            builder.setView(custom_view)

            builder.setPositiveButton("확인"){_, _ ->
                custom_view.run {
                    val custom_edit1 = findViewById<EditText>(R.id.custom_edit1)
                    val custom_edit2 = findViewById<EditText>(R.id.custom_edit2)
                    textView.text = "${custom_edit1.text}\n"
                    textView.append("${custom_edit2.text}")
                }
            }

            builder.setNegativeButton("취소", null)

            builder.show()
        }

        button3.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val listener1 = object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    textView.text = "${year}년 ${month+1} 월 $dayOfMonth 일"
                }

            }

            val picker = DatePickerDialog(this, listener1, year, month, day)

            picker.show()
        }

        button4.setOnClickListener {
            val calendar = Calendar.getInstance()

            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            val listener2 = object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    textView.text = "$hourOfDay 시 $minute 분"
                }
            }

            val picker = TimePickerDialog(this, listener2, hour, minute, true)
            picker.show()
        }
    }
}