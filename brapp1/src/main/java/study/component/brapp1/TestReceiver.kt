package study.component.brapp1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val str = "Broad Cast Receiver가 동작하였습니다."
        val t1 = Toast.makeText(context, str, Toast.LENGTH_SHORT)
        t1.show()
    }
}