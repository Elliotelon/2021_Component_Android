package study.component.toast

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}
    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    private val toast_image by lazy {findViewById<ImageView>(R.id.toast_image)}
    private val toast_text by lazy {findViewById<TextView>(R.id.toast_text)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //토스트 객체를 생성한다.
            val t1 = Toast.makeText(this, "기본 Toast 입니다.", Toast.LENGTH_SHORT)

            //callback 객체 생성
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                val callback = object : Toast.Callback(){
                    override fun onToastHidden() {
                        super.onToastHidden()
                        textView.text = "Toast 메시지가 사라졌습니다."
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        textView.text = "Toast 메시지가 나타났습니다."
                    }
                }

                t1.addCallback(callback)
            }
            t1.show()
        }

        button2.setOnClickListener {

            //Toast에 보여줄 View를 생성한다.
            val toastView = layoutInflater.inflate(R.layout.custom_toast, null)

//            toastView.run {
//                toast_image.setImageResource(R.drawable.img_android)
//                toast_text.text = "Custom Toast 입니다."
//            }

            toastView.setBackgroundResource(android.R.drawable.toast_frame)

            //Toast 객체를 생성한다.
            val t2 = Toast(this)
            //View를 설정한다.
            t2.view = toastView

            t2.setGravity(Gravity.CENTER, 0, 300)

            t2.duration = Toast.LENGTH_LONG

            t2.show()
        }
    }
}