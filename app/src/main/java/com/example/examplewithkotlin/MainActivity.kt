package com.example.examplewithkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examplewithkotlin.model.PhoneModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragments()
    }

    private fun setFragments() {
        val listFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }

    fun goDetail(data: PhoneModel) {
        val bundle = Bundle()
        bundle.putString("name", data.name)
        bundle.putString("phone", data.phone)
        bundle.putInt("age", data.age)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack() {
       onBackPressed()
    }
}