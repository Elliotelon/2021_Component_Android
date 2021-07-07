package study.component.listfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.ListFragment

class SubFragment : ListFragment() {

    lateinit var sub_text1 : TextView

    val data1 = arrayOf(
        "항목1","항목2","항목3","항목4",
        "항목5","항목6","항목7","항목8"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sub, null)
        sub_text1 = view.findViewById<TextView>(R.id.sub_text1)
        val adapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, data1)

        listAdapter = adapter

        return view
    }

    //리스트뷰의 항목을 터치했을때 호출되는 메소드
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        sub_text1.text = data1[position]
    }
}