package study.component.permission

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    private val button by lazy {findViewById<Button>(R.id.button)}

    val permission_list = arrayOf(
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = ""

        for(permission in permission_list){
            //권한 여부를 확인한다.
            val chk = checkCallingOrSelfPermission(permission)

            if(chk == PackageManager.PERMISSION_GRANTED){
                textView.append("$permission : 허용\n")
            } else if(chk == PackageManager.PERMISSION_DENIED){
                textView.append("$permission : 거부\n")
            }
        }

        button.setOnClickListener{
            //거부 되어 있는 권한들을 사용자에게 확인 받는다.
            requestPermissions(permission_list, 0)

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        textView.text = ""

        for(idx in grantResults.indices){
            if(grantResults[idx] == PackageManager.PERMISSION_GRANTED){
                textView.append("${permissions[idx]} : 허용\n")
            } else if(grantResults[idx] == PackageManager.PERMISSION_DENIED){
                textView.append("${permissions[idx]} : 거부\n")
            }
        }
    }
}