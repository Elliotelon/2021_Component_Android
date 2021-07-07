package study.component.activityanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

            //overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            overridePendingTransition(R.anim.slide_xml1, R.anim.slide_xml2)
        }
    }
}