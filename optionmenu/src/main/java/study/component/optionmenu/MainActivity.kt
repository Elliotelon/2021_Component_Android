package study.component.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //XML로 메뉴를 구성한다.
        //menuInflater.inflate(R.menu.main_menu, menu)

        menu?.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드 메뉴1")
        //menu?.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "코드 메뉴2")
        val sub = menu?.addSubMenu("코드 메뉴2")
        sub?.add(Menu.NONE, Menu.FIRST+10, Menu.NONE, "코드 메뉴2-1")
        sub?.add(Menu.NONE, Menu.FIRST+20, Menu.NONE, "코드 메뉴2-2")

        menu?.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "코드 메뉴3")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // 메뉴의 id 별로 분기한다.

//        when(item.itemId){
//            R.id.item1 -> {
//                textView.text = "메뉴1을 눌렀습니다."
//            }
//            R.id.item2_1 ->{
//                textView.text = "메뉴2-1을 눌렀습니다."
//            }
//            R.id.item2_2 ->{
//                textView.text = "메뉴2-2를 눌렀습니다."
//            }
//            R.id.item3 -> {
//                textView.text = "메뉴3을 눌렀습니다."
//            }
//        }

        when(item.itemId){
            Menu.FIRST -> {
                textView.text = "코드 메뉴1을 눌렀습니다."
            }
            Menu.FIRST + 10 -> {
                textView.text = "코드 메뉴2-1을 눌렀습니다."
            }
            Menu.FIRST + 20 -> {
                textView.text = "코드 메뉴2-2를 눌렀습니다."
            }
            Menu.FIRST + 2 -> {
                textView.text = "코드 메뉴3을 눌렀습니다."
            }
        }

        return super.onOptionsItemSelected(item)
    }

}