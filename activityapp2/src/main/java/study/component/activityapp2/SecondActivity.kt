package study.component.activityapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getStringExtra("data2")

        textView.text = "data1 : ${data1}\n"
        textView.append("data2 : ${data2}")

        button.setOnClickListener {

            val result_intent = Intent()
            result_intent.putExtra("value1", 200)
            result_intent.putExtra("value2", "문자열2")

            setResult(RESULT_OK, result_intent)

            finish()
        }
    }
}