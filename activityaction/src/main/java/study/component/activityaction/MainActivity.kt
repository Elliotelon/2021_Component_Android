package study.component.activityaction

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val permission_list = arrayOf(
        Manifest.permission.CALL_PHONE
    )

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}
    private val button3 by lazy {findViewById<Button>(R.id.button3)}
    private val button4 by lazy {findViewById<Button>(R.id.button4)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions(permission_list, 0)

        button.setOnClickListener {

            val uri = Uri.parse("geo:37.243243,131.861601")

            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }

        button2.setOnClickListener {

            val uri = Uri.parse("https://developer.android.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val uri = Uri.parse("tel:12341234")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val uri = Uri.parse("tel:12341234")
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
    }
}