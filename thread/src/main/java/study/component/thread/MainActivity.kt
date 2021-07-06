package study.component.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var isRunning = false

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}

    private val button by lazy {findViewById<Button>(R.id.button)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val now = System.currentTimeMillis()
            textView.text = "버튼클릭 : $now"
        }

//        while (true){
//            SystemClock.sleep(100)
//            val now2 = System.currentTimeMillis()
//            Log.d("test", "while 문 : $now2")
//        }

        isRunning = true

//        val thread1 = object : Thread(){
//            override fun run() {
//                super.run()
//                while (isRunning){
//                    SystemClock.sleep(100)
//                    val now2 = System.currentTimeMillis()
//                    Log.d("test", "Thread : $now2")
//                    textView2.text = "Thread : ${now2}"
//                }
//            }
//        }
//        thread1.start()

        thread {
            while (isRunning){
                SystemClock.sleep(100)
                val now2 = System.currentTimeMillis()
                Log.d("test", "Thread : $now2")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}