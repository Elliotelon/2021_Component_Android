package study.component.fragmentview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    private val container1 by lazy {findViewById<FrameLayout>(R.id.container1)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag = SubFragment()
        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container1, frag)
        tran.commit()
    }
}