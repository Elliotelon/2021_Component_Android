package study.component.activitycontroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_result, null)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result_text1 = view.findViewById<TextView>(R.id.result_text1)
        val result_text2 = view.findViewById<TextView>(R.id.result_text2)

        val mainActivity = activity as MainActivity

        result_text1.text = mainActivity.value1
        result_text2.text = mainActivity.value2
    }
}