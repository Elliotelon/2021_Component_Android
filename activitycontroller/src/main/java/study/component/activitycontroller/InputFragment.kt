package study.component.activitycontroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    lateinit var input_button : Button
    lateinit var input_edit1 : EditText
    lateinit var input_edit2 : EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_input, null)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        input_button = view.findViewById<Button>(R.id.input_button)
        input_edit1 = view.findViewById<EditText>(R.id.input_edit1)
        input_edit2 = view.findViewById<EditText>(R.id.input_edit2)

        input_button.setOnClickListener {
            val mainActivity = activity as MainActivity

            mainActivity.value1 = input_edit1.text.toString()
            mainActivity.value2 = input_edit2.text.toString()

            mainActivity.setFragment("result")
        }
    }

    override fun onResume() {
        super.onResume()
        input_edit1.setText("")
        input_edit2.setText("")
    }
}