package study.component.runonuithread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var isRunning = false

    private val button by lazy {findViewById<Button>(R.id.button)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val now = System.currentTimeMillis()
            textView.text = "버튼 클릭 : $now"
        }

        isRunning = true
        thread {
            while (isRunning){
                SystemClock.sleep(500)
                val now2 = System.currentTimeMillis()
                Log.d("test", "thread : $now2")

//                runOnUiThread(object : Thread(){
//                    override fun run() {
//                        super.run()
//                        textView2.text = "runOnUiThread : $now2"
//                    }
//                })

                runOnUiThread {
                    textView2.text = "runOnUiThread : $now2"
                }

                SystemClock.sleep(500)

//                runOnUiThread(object: Thread(){
//                    override fun run() {
//                        super.run()
//                        textView2.text = "또 다른 작업임"
//                    }
//                })

                runOnUiThread {
                    textView2.text = "또 다른 작업"
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}