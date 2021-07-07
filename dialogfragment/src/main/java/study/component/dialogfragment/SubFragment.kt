package study.component.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class SubFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val mainActivity = activity as MainActivity

        val builder = AlertDialog.Builder(mainActivity)
        builder.setTitle("타이틀 입니다.")
        builder.setMessage("메시지 입니다.")

        builder.setPositiveButton("positive"){ _,_ ->
            mainActivity.findViewById<TextView>(R.id.textView).text = "Positive"
        }

        builder.setNeutralButton("Neutral"){_,_ ->
            mainActivity.findViewById<TextView>(R.id.textView).text = "Neutral"
        }

        builder.setNegativeButton("Negative"){_,_ ->
            mainActivity.findViewById<TextView>(R.id.textView).text = "Negative"
        }

        val alert = builder.create()
        return alert

    }
}