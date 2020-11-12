package com.example.examplewithkotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {
    var mainActivity: MainActivity? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        view.backButton.setOnClickListener(View.OnClickListener {
            mainActivity?.goBack()
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getArgumentsAndSetData()
    }

    private fun getArgumentsAndSetData() {
        val name = this.arguments?.getString("name")
        if (name != null) {
            nameTextView.setText(name)
        }

        val age = this.arguments?.getInt("age")
        if (age != null) {
            ageTextView.setText(String.format("%d", age))
        }

        val phone = this.arguments?.getString("phone")
        if (phone != null) {
            phoneTextView.setText(phone)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
}