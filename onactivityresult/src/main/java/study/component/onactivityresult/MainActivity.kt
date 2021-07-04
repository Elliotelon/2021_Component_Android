package study.component.onactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 100
    val THIRD_ACTIVITY = 200

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button4 by lazy {findViewById<Button>(R.id.button4)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val second_intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(second_intent, SECOND_ACTIVITY)
        }

        button4.setOnClickListener {
            val third_intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(third_intent, THIRD_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            SECOND_ACTIVITY -> {
                textView.text = "SecondActivity에서 돌아왔습니다."
            }
            THIRD_ACTIVITY -> {
                textView.text = "ThirdActivity에서 돌아왔습니다.\n"
                when(resultCode){
                    Activity.RESULT_OK -> {
                        textView.append("결과 : OK")
                    }
                    Activity.RESULT_CANCELED -> {
                        textView.append("결과 : CANCELED")
                    }
                    Activity.RESULT_FIRST_USER -> {
                        textView.append("결과 : USER1")
                    }
                    Activity.RESULT_FIRST_USER+1 -> {
                        textView.append("결과 : USER2")
                    }
                }
            }
        }
    }
}