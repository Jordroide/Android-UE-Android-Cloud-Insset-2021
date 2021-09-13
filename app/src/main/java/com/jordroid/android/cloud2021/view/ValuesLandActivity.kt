package com.jordroid.android.cloud2021.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordroid.android.cloud2021.R
import com.jordroid.android.cloud2021.databinding.ActivityValuesBinding

class ValuesLandActivity: AppCompatActivity() {

    private lateinit var binding : ActivityValuesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValuesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchValuesLand.text = getString(R.string.random_string)
        binding.switchValuesLand.isEnabled = resources.getBoolean(R.bool.flag)
    }
}