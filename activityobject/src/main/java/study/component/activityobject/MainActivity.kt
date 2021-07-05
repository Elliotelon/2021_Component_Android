package study.component.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 0

    private val button by lazy {findViewById<Button>(R.id.button)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val second_intent = Intent(this, SecondActivity::class.java)

            val t1 = TestClass()
            t1.data1 = 100
            t1.data2 = "문자열1"

            second_intent.putExtra("obj1", t1)


            //startActivity(second_intent)

            startActivityForResult(second_intent, SECOND_ACTIVITY)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == SECOND_ACTIVITY){
            if(resultCode == RESULT_OK){
                //객체를 추출한다.
                val obj2 = data?.getParcelableExtra<TestClass>("obj2")
                textView.text = "obj2.data1 : ${obj2?.data1}\n"
                textView.append("obj2.data2 : ${obj2?.data2}")
            }
        }
    }
}