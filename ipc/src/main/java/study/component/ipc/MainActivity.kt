package study.component.ipc

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //접속한 서비스 객체
    var ipcService:TestService? = null

    //서비스 접속을 관리하는 객체
    val connection = object : ServiceConnection{
        //서비스에 접속이 성공했을때
        // 두번째 : 서비스의 onBind 메소드가 반환하는 객체를 받는다.
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //서비스를 추출한다.
            val binder = service as TestService.LocalBInder
            ipcService = binder.getService()

        }

        //서비스 접속을 해제했을 때
        override fun onServiceDisconnected(name: ComponentName?) {
            ipcService = null
        }

    }

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 서비스가 가동중이 아니라면 서비스를 가동한다.
        val chk = isServiceRunning("study.component.ipc.TestService")
        val serviceIntent = Intent(this, TestService::class.java)
        if(chk == false){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(serviceIntent)
            }else {
                startService(serviceIntent)
            }
        }
        //서비스에 접속한다.
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)

        button.setOnClickListener {
            var value = ipcService?.getNumber()
            textView.text = "value : $value"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //접속한 서비스에 접속을 해제한다.
        unbindService(connection)
    }

    //서비스 실행 여부를 검사하는 메소드
    fun isServiceRunning(name:String) : Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        //현재 실행중인 서비스들을 가져온다.
        val serviceList = manager.getRunningServices(Int.MAX_VALUE)

        for(serviceInfo in serviceList){
            //서비스의 이름이 원하는 이름인가..
            if(serviceInfo.service.className == name){
                return true
            }
        }

        return false
    }
}