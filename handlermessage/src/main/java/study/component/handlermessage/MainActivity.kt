package study.component.handlermessage

import android.os.*
import androidx.appcompat.app.AppCompatActivity
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

        //화면 처리를 위한 핸들러
        val handler1 = object : Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                when(msg.what){
                    0 -> {
                        textView2.text = "handler 0"
                    }
                    1 -> {
                        textView2.text = "handler 1"
                    }
                    2 -> {
                        textView2.text = "handler 2 : ${msg.arg1}, ${msg.arg2}, ${msg.obj}"
                    }
                }
            }
        }

        //오래 걸리는 작업 - 쓰레드 발생
        isRunning = true
        thread {
            while (isRunning){
                val now2 = System.currentTimeMillis()
                Log.d("test", "오래 걸리는 작업 : $now2")

                SystemClock.sleep(500)

                handler1.sendEmptyMessage(0)

                SystemClock.sleep(500)
                handler1.sendEmptyMessage(1)

                SystemClock.sleep(500)
                val msg = Message()
                msg.what = 2
                msg.arg1 = 100
                msg.arg2 = 200
                msg.obj = "객체"
                handler1.sendMessage(msg)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}