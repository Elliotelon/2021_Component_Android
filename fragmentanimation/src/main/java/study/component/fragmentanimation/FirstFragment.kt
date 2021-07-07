package study.component.fragmentanimation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_first, null)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    
        val first_button1 = view.findViewById<Button>(R.id.first_button1)
        val first_text1 = view.findViewById<TextView>(R.id.first_text1)

        first_button1.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setFragment("second")
        }
    }
}