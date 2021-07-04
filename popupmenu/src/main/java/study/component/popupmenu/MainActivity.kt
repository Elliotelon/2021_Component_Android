package study.component.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    private val button by lazy {findViewById<Button>(R.id.button)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //PopupMenu 객체를 생성한다.
            val pop = PopupMenu(this, textView)

            //메뉴를 구성한다.
            menuInflater.inflate(R.menu.menu1, pop.menu)

            pop.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.item1 -> {
                        textView.text = "메뉴1을 눌렀습니다."
                    }
                    R.id.item2 -> {
                        textView.text = "메뉴2를 눌렀습니다."
                    }
                    R.id.item3 -> {
                        textView.text = "메뉴3을 눌렀습니다."
                    }
                }
                true
            }

            pop.show()
        }

    }
}