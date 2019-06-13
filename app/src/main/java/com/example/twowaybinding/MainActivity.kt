package com.example.twowaybinding

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.twowaybinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel:MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.personUpdate().observe(this, Observer {
            binding.data = it
        })
        viewModel.callOnSubmitClick().observe(this, Observer {
            viewModel.submit()
        })

    }
}
