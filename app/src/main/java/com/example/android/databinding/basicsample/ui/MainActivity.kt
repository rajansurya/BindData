package com.example.android.databinding.basicsample.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.android.databinding.basicsample.ui.ObservableFieldActivity
//import society.doscon.com.binddata.R
import society.doscon.com.binddata.R
import society.doscon.com.binddata.databinding.ActivityMainBinding

class MainActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.observableFieldsActivityButton.setOnClickListener {
//            startActivity(Intent(this, ObservableFieldActivity::class.java))
//        }

        binding.observableFieldsActivityButton.setOnClickListener {
            startActivity(Intent(this, ObservableFieldActivity::class.java))
        }
        binding.viewmodelActivityButton.setOnClickListener {
            startActivity(Intent(this, ViewModelActivity::class.java))
        }
    }
}