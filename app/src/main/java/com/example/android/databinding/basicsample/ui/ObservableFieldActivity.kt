package com.example.android.databinding.basicsample.ui

import android.databinding.DataBindingUtil
import android.databinding.ObservableInt
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.android.databinding.basicsample.data.ObservableFieldProfile
import society.doscon.com.binddata.R
import society.doscon.com.binddata.databinding.ObservableFieldProfileBinding

class ObservableFieldActivity:AppCompatActivity(){
    private val observableFieldProfile = ObservableFieldProfile("Ada", "Lovelace", ObservableInt(0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ObservableFieldProfileBinding =
                DataBindingUtil.setContentView(this, R.layout.observable_field_profile)
        binding.user = observableFieldProfile
    }

    fun onLike(view: View) {
        observableFieldProfile.likes.set(observableFieldProfile.likes.get() + 1)
    }
}