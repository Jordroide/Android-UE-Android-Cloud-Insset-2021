package com.jordroid.android.cloud2021.remoteConfig.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jordroid.android.cloud2021.databinding.ActivityRemoteConfigBinding
import com.jordroid.android.cloud2021.remoteConfig.viewModel.RemoteConfigurationViewModel

class RemoteConfigurationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRemoteConfigBinding
    private lateinit var viewModel: RemoteConfigurationViewModel
    private val observer = Observer<Boolean> {
        updateUi(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRemoteConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RemoteConfigurationViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        viewModel.remoteConfiguration.observe(this, observer)
    }

    override fun onStop() {
        viewModel.remoteConfiguration.removeObserver(observer)
        super.onStop()
    }

    private fun updateUi(state: Boolean) {
        binding.cardViewFeature2.visibility = if (state) View.VISIBLE else View.GONE
    }
}