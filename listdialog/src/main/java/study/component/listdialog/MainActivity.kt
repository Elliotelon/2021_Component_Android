package study.component.listdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
        "항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8"
    )

    val data2 = arrayOf(
        "토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"
    )

    val data3 = intArrayOf(
        R.drawable.imgflag1,  R.drawable.imgflag2, R.drawable.imgflag3,  R.drawable.imgflag4,
        R.drawable.imgflag5,  R.drawable.imgflag6,  R.drawable.imgflag7,  R.drawable.imgflag8
    )

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 다이얼로그")
            builder.setNegativeButton("취소", null)

            builder.setItems(data1){_, i ->
                textView.text = "기본 리스트 다이얼로그 : ${data1[i]}"
            }

            builder.show()
        }

        button2.setOnClickListener {
            val list1 = ArrayList<HashMap<String, Any?>>()

            for(idx in data2.indices){
                val map = HashMap<String, Any?>()
                map["data2"] = data2[idx]
                map["data3"] = data3[idx]

                list1.add(map)
            }

            val keys = arrayOf("data2", "data3")
            val ids = intArrayOf(R.id.custom_text, R.id.custom_image)

            val adapter = SimpleAdapter(this, list1, R.layout.custom_list, keys, ids)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 리스트 다이얼로그")

            builder.setAdapter(adapter){_, i ->
                textView.text = "커스텀 리스트 다이얼로그 : ${data2[i]}"
            }

            builder.setNegativeButton("취소", null)

            builder.show()

        }
    }
}