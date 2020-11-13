package com.example.examplewithkotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {
    var mainActivity: MainActivity? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        setEventListener(view)
        getArgumentsAndSetData(view)
        return view
    }

    private fun setEventListener(view: View) {
        view.backButton.setOnClickListener(View.OnClickListener {
//            mainActivity?.goBack()
        })
    }

    private fun getArgumentsAndSetData(view: View) {
        val name = arguments?.getString("name")
        if (name != null) {
            view.nameTextView.setText(name)
        }

        val age = arguments?.getInt("age")
        if (age != null) {
            view.ageTextView.setText(String.format("%d", age))
        }

        val phone = arguments?.getString("phone")
        if (phone != null) {
            view.phoneTextView.setText(phone)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
}