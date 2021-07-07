package study.component.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

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

        val handler = Handler(Looper.myLooper()!!)

        //처리 한번에 대한 작업을 구현해준다.
        val thread1 = object : Thread(){
            override fun run() {
                super.run()
                val now2 = System.currentTimeMillis()
                textView2.text = "handler : $now2"

                //handler.post(this)
                handler.postDelayed(this, 100)
            }
        }

        //handler.post(thread1)
        handler.postDelayed(thread1, 100)
    }

}