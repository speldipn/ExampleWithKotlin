package com.example.examplewithkotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val listFragment = ListFragment()
    val practiceFragment = PracticeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtons()
    }

    private fun addListFragment() {
        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.frameLayout, listFragment)
        transaction.add(R.id.frameLayout, practiceFragment)
        transaction.commit()
    }

    private fun delListFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.remove(practiceFragment)
//        transaction.remove(listFragment)
        transaction.commit()
    }
    private fun setButtons() {
        addButton.setOnClickListener(View.OnClickListener {
            this.addListFragment()
        })
        delButton.setOnClickListener(View.OnClickListener {
            this.delListFragment()
        })
    }
}