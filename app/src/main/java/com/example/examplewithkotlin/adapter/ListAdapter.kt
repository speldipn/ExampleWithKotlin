package com.example.examplewithkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examplewithkotlin.R
import com.example.examplewithkotlin.model.PhoneModel
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter: RecyclerView.Adapter<PhoneVH>() {
    var phoneList: MutableList<PhoneModel> = mutableListOf()
    var clickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        view.setOnClickListener(clickListener)
        return PhoneVH(view)
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    override fun onBindViewHolder(holder: PhoneVH, position: Int) {
        val phone = phoneList.get(position)
        holder.setData(phone)
    }

    fun setDataAndRefresh(list: MutableList<PhoneModel>) {
        phoneList = list
        notifyDataSetChanged()
    }

    fun setClickEventListener(onClickListener: View.OnClickListener) {
       clickListener = onClickListener
    }

    fun getData(): MutableList<PhoneModel> {
       return phoneList
    }
}

class PhoneVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(data: PhoneModel) {
        itemView.nameTextView.setText(data.name)
        itemView.ageTextView.setText(data.age.toString())
        itemView.phoneTextView.setText(data.phone)
    }
}
