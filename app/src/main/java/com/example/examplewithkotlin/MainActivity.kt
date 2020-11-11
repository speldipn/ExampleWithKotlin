package com.example.examplewithkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.examplewithkotlin.adapter.ListAdapter
import com.example.examplewithkotlin.model.PhoneModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var phoneList:MutableList<PhoneModel>? = null
    var phoneAdapter: ListAdapter? = ListAdapter()

    init {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView?.adapter = phoneAdapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}