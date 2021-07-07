package study.component.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}
    private val container1 by lazy {findViewById<FrameLayout>(R.id.container1)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag = SubFragment()

        button.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container1, frag)
            tran.addToBackStack(null)
            tran.commit()
        }

        button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.remove(frag)
            tran.commit()
        }
    }
}