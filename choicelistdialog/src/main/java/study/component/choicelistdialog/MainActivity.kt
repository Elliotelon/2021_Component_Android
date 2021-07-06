package study.component.choicelistdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    val data1 = arrayOf(
            "항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Single Choice List")
            builder.setSingleChoiceItems(data1, 3){_,i ->
                val t1 = Toast.makeText(this, data1[i], Toast.LENGTH_SHORT)
                t1.show()
            }

            builder.setNegativeButton("취소", null)
            builder.setPositiveButton("확인"){dialog, i ->

                val alert = dialog as AlertDialog

                val idx = alert.listView.checkedItemPosition
                textView.text = "선택된 항목 : ${data1[idx]}"
            }


            builder.show()

        }

        button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val boolArray = booleanArrayOf(true, false, false, true, false, false, false, false)

            builder.setTitle("Multi Choice List")
            builder.setMultiChoiceItems(data1, boolArray){dialog, i, b ->

                if(b == true){
                    val t1 = Toast.makeText(this, "${data1[i]}가 체크 되었습니다.", Toast.LENGTH_SHORT)
                    t1.show()
                } else {
                    val t2 = Toast.makeText(this, "${data1[i]}가 체크 해제 되었습니다.", Toast.LENGTH_SHORT)
                    t2.show()
                }
            }

            builder.setNegativeButton("취소", null)

            builder.setPositiveButton("확인"){dialog, i ->
                val alert = dialog as AlertDialog

                textView.text = ""

                val positions = alert.listView.checkedItemPositions

                for(i in 0 until positions.size()){

                    //체크상태가 변경된 항목의 인덱스 번호를 추출한다.
                    var index = positions.keyAt(i)

                    if(positions.get(index) == true){
                        textView.append("${data1[index]} ")
                    }

                }
            }

            builder.show()
        }
    }
}