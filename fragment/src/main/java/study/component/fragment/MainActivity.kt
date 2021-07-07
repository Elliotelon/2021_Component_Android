package study.component.fragment

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

        val frag1 = FirstFragment()
        val frag2 = SecondFragment()

        button.setOnClickListener {
            //Fragment 작업 시작
            val tran = supportFragmentManager.beginTransaction()
            //Fragment를 셋팅한다.
            //tran.add(R.id.container1, frag1)
            tran.replace(R.id.container1, frag1)
            tran.addToBackStack(null)
            tran.commit()
        }

        button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            //tran.add(R.id.container1, frag2)
            tran.replace(R.id.container1, frag2)
            tran.addToBackStack(null)
            tran.commit()
        }
    }
}