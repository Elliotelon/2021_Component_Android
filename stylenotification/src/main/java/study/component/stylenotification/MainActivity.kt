package study.component.stylenotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}
    private val button3 by lazy {findViewById<Button>(R.id.button3)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val builder1 = getNotificationBuilder("style", "style Notification")
            builder1.setContentTitle("Big Picture")
            builder1.setContentText("Big Picture Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //BigPicture Notification 객체를 생성한다.
            val big = NotificationCompat.BigPictureStyle(builder1)

            //보여줄 이미지를 설정한다.
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
            big.bigPicture(bitmap)
            big.setBigContentTitle("Big Content Title")
            big.setSummaryText("Summary Text")

            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        button2.setOnClickListener {
            val builder1 = getNotificationBuilder("style", "style Notification")
            builder1.setContentTitle("Big Text")
            builder1.setContentText("Big Text Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //Big Text Notification을 생성한다.
            val big = NotificationCompat.BigTextStyle(builder1)
            big.setSummaryText("Summary Text")
            big.setBigContentTitle("Big Content Title")
            big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세")

            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        button3.setOnClickListener {
            val builder1 = getNotificationBuilder("style", "style Notification")
            builder1.setContentTitle("Big InBox")
            builder1.setContentText("Big InBox Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //InBox Style Notification을 생성한다.
            val inbox = NotificationCompat.InboxStyle(builder1)
            inbox.setSummaryText("Summary Text")
            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            inbox.addLine("cccccccccccccccccccccccccccccccccccccccccccccccccccc")
            inbox.addLine("dddddddddddddddddddddddddddddddddddddddddddddddddddd")
            inbox.addLine("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")

            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)
        }
    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder{

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, id)
            return builder
        }else {
            val builder = NotificationCompat.Builder(this)
            return builder
        }
    }
}