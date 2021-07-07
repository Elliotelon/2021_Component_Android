package study.component.brapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val brIntent = Intent("study.component.testbr")
            sendBroadcast(brIntent)
        }
    }
}