package com.example.examplewithkotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val listFragment = ListFragment()
    val practiceFragment = PracticeFragment()
    var isAttachFragment = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtons()
    }

    private fun addListFragment() {
        if(isAttachFragment) { return }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, practiceFragment)
        transaction.commit()
        isAttachFragment = true;
    }

    private fun delListFragment() {
        if(!isAttachFragment) { return }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.remove(practiceFragment)
        transaction.commit()
        isAttachFragment = false;
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