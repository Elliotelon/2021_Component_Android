package study.component.activityanimation

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

        button2.setOnClickListener {
            finishActivity()
        }
    }

    //Backbutton을 누르면 호출되는 메소드
    override fun onBackPressed() {
        finishActivity()
    }

    fun finishActivity(){
        finish()
        //overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        overridePendingTransition(R.anim.slide_xml3, R.anim.slide_xml4)
    }
}