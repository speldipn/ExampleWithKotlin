package com.example.examplewithkotlin.fragments

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.examplewithkotlin.MainActivity
import com.example.examplewithkotlin.R

class OneFragment : Fragment() {

    companion object {
        val QUERY_PERMISSION = 10
    }

    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(!checkPermission()) {
            queryPermission()
        } else {
            init()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode) {
            QUERY_PERMISSION -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    init()
                } else {
                    mainActivity.finish()
                }
            }
        }
    }

    private fun queryPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), QUERY_PERMISSION)
        }
    }

    private fun checkPermission(): Boolean {
        val permission = context?.let { ContextCompat.checkSelfPermission(it, android.Manifest.permission.CAMERA) }
        return permission == PackageManager.PERMISSION_GRANTED
    }

    private fun init() {
        Toast.makeText(context, "Initialized done", Toast.LENGTH_SHORT).show()
    }

}