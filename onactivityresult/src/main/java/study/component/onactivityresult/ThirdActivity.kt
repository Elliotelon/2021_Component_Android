package study.component.onactivityresult

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {

    private val button3 by lazy {findViewById<Button>(R.id.button3)}
    private val button5 by lazy {findViewById<Button>(R.id.button5)}
    private val button6 by lazy {findViewById<Button>(R.id.button6)}
    private val button7 by lazy {findViewById<Button>(R.id.button7)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        button3.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
        button5.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        button6.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }
        button7.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER+1)
            finish()
        }

    }
}