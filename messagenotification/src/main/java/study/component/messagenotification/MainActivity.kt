package study.component.messagenotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                val builder1 = getNotificationBuilder("message", "message style")
                builder1.setContentTitle("Message Style")
                builder1.setContentText("Message Style Notification")
                builder1.setSmallIcon(android.R.drawable.ic_input_delete)

                val personBulder1 = Person.Builder()
                val icon1 = IconCompat.createWithResource(this, android.R.drawable.ic_media_next)
                personBulder1.setIcon(icon1)
                personBulder1.setName("홍길동")
                val person1 = personBulder1.build()

                val personBulder2 = Person.Builder()
                val icon2 = IconCompat.createWithResource(this, R.mipmap.ic_launcher)
                personBulder2.setIcon(icon2)
                personBulder2.setName("최길동")
                val person2 = personBulder2.build()

                val messageStyle = NotificationCompat.MessagingStyle(person1)

                messageStyle.addMessage("첫번째 메시지", System.currentTimeMillis(), person1)
                messageStyle.addMessage("두번째 메시지", System.currentTimeMillis(), person2)
                messageStyle.addMessage("세번째 메시지", System.currentTimeMillis(),person1)
                messageStyle.addMessage("네번째 메시지", System.currentTimeMillis(),person2)

                builder1.setStyle(messageStyle)

                val notification = builder1.build()
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.notify(10, notification)

            }
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
        } else {
            val builder = NotificationCompat.Builder(this)
            return builder
        }


    }
}