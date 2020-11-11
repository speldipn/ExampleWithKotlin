package com.example.examplewithkotlin

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
    var phoneList:MutableList<PhoneModel>? = null
    var phoneAdapter: ListAdapter? = ListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // joonyoung
        // This method is equal to onCreateViewHolder of recycler view
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setup()
        recyclerView?.adapter = phoneAdapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun setup() {
        phoneList = mutableListOf()
        for (i in 1..20) {
            var phone = "010-7319-5025"
            if(i > 5 && i % 2 == 1) {
                for(j in 0 .. i) {
                    phone += String.format("%d ", i)
                }
            }
            phoneList?.add(PhoneModel("Neo" + i,  i, phone))
        }
        phoneAdapter?.setDataAndRefresh(phoneList!!)
    }
}