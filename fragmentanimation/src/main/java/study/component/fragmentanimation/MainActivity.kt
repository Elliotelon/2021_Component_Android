package study.component.fragmentanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {


    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment("first")
    }

    fun setFragment(name:String){
        val tran = supportFragmentManager.beginTransaction()

        when(name){
            "first" -> {
                tran.replace(R.id.container1, firstFragment)
            }
            "second" -> {
                //tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                //tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                //tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)

                //tran.setCustomAnimations(R.anim.fade_xml1, R.anim.fade_xml2, R.anim.fade_xml1, R.anim.fade_xml2)

                tran.setCustomAnimations(R.anim.slide_xml1, R.anim.slide_xml2, R.anim.slide_xml3, R.anim.slide_xml4)

                tran.replace(R.id.container1, secondFragment)
                tran.addToBackStack(null)
            }
        }
        tran.commit()
    }
}