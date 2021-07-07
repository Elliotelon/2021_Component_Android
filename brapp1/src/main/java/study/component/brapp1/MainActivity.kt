package study.component.brapp1

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}

    val br = TestReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 8.0 이상 부터는 코드를 통해 등록하고 해제 해야한다.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val filter = IntentFilter("study.component.testbr")
            registerReceiver(br, filter)
        }

        button.setOnClickListener {
            //val brIntent = Intent(this, TestReceiver::class.java)
            val brIntent = Intent("study.component.testbr")
            sendBroadcast(brIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            unregisterReceiver(br)
        }
    }
}