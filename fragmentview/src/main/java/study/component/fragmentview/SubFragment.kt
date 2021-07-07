package study.component.fragmentview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SubFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sub, null)

        return view
    }

    //Fragment가 관리하는 View 내부의 View의 주소값들이 셋팅된 후
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //내부의 View들의 주소값을 가져온다.
        val text1 = view.findViewById<TextView>(R.id.frag_text1)
        val btn1 = view.findViewById<Button>(R.id.frag_btn1)
        val btn2 = view.findViewById<Button>(R.id.frag_btn2)

        btn1.setOnClickListener {
            text1.text = "Fragment 문자열"
        }

        btn2.setOnClickListener {
            // MainActivity를 추출한다.
            val parent = activity as MainActivity
            parent.findViewById<TextView>(R.id.activity_text1).text = "Activity 문자열"
        }
    }
}