package com.example.android.databinding.basicsample.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.databinding.basicsample.data.ProfileObservableViewModel
import society.doscon.com.binddata.R
import society.doscon.com.binddata.databinding.ViewmodelProfileBinding

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtain ViewModel from ViewModelProviders
        val viewModel = ViewModelProviders.of(this).get(ProfileObservableViewModel::class.java)

        // Obtain binding
        val binding: ViewmodelProfileBinding = DataBindingUtil.setContentView(this, R.layout.viewmodel_profile)

        // Bind layout with ViewModel
        binding.viewmodel = viewModel
    }
}