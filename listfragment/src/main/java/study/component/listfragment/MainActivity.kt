package study.component.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subFragment = SubFragment()
        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container1, subFragment)
        tran.commit()
    }
}