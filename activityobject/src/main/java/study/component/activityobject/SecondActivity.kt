package study.component.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private val button2 by lazy {findViewById<Button>(R.id.button2)}

    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val obj1 = intent.getParcelableExtra<TestClass>("obj1")

        textView2.text = "obj1.data1 : ${obj1?.data1}\n"
        textView2.append("obj1.data2 : ${obj1?.data2}")

        button2.setOnClickListener {

            val t2 = TestClass()
            t2.data1 = 200
            t2.data2 = "문자열2"

            val result_intent = Intent()
            result_intent.putExtra("obj2", t2)
            setResult(RESULT_OK, result_intent)

            finish()
        }
    }
}