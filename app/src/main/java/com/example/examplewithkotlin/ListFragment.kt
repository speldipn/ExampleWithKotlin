package com.example.examplewithkotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.examplewithkotlin.adapter.ListAdapter
import com.example.examplewithkotlin.model.PhoneModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    var mainActivity:MainActivity? = null
    var phoneAdapter: ListAdapter? = ListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setup()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity?
    }

    private fun setup() {
        phoneAdapter?.setDataAndRefresh(getData())
        phoneAdapter?.setClickEventListener(View.OnClickListener { view ->
            mainActivity?.goDetail()
        })
        recyclerView?.adapter = phoneAdapter
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun getData(): MutableList<PhoneModel> {
        var phoneList = mutableListOf<PhoneModel>()
        for (i in 1..20) {
            var phone = "010-7319-5025"
            if (i > 5 && i % 2 == 1) {
                for (j in 0..i) {
                    phone += String.format("%d ", i)
                }
            }
            phoneList.add(PhoneModel("Neo" + i, i, phone))
        }
        return phoneList
    }

}