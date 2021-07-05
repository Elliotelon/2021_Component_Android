package study.component.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //val snack1 = Snackbar.make(it, "기본 스낵바", Snackbar.LENGTH_SHORT)
            val snack1 = Snackbar.make(it, "기본 스낵바", Snackbar.LENGTH_INDEFINITE)

            snack1.setTextColor(Color.RED)
            snack1.setBackgroundTint(Color.BLUE)
            snack1.animationMode = Snackbar.ANIMATION_MODE_FADE

            val callback = object : BaseTransientBottomBar.BaseCallback<Snackbar>(){
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                    textView2.text = "SnackBar가 나타났습니다."
                }

                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    textView2.text = "SnackBar가 사라졌습니다."
                }
            }

            snack1.addCallback(callback)

            snack1.setAction("Action"){
                textView.text = "Action Click"
            }

            snack1.show()
        }

        button2.setOnClickListener {
            //스낵바를 만들어준다.
            val snack2 = Snackbar.make(it, "Custom SnackBar", Snackbar.LENGTH_SHORT)

            //스낵바를 통해 보여줄 뷰를 생성한다.
            val snackView = layoutInflater.inflate(R.layout.custom_snackbar, null)

            snackView.run {
                findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.img_android)
                findViewById<TextView>(R.id.textView3).text = "새로 추가된 View"
                findViewById<TextView>(R.id.textView3).setTextColor(Color.WHITE)
            }

            //스낵바 레이아웃을 추출해서 새로운 뷰를 추가한다.
            val snackbarLayout = snack2.view as Snackbar.SnackbarLayout
            snackbarLayout.addView(snackView)

            //스낵바에 있는 TextView를 추출해 이를 보이지 않게 처리한다.
            val snackText = snackbarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackText.visibility = View.INVISIBLE

            snack2.show()
        }
    }
}