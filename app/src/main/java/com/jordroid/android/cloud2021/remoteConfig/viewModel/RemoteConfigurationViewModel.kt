package com.jordroid.android.cloud2021.remoteConfig.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jordroid.android.cloud2021.remoteConfig.repository.RemoteConfigurationRepository

class RemoteConfigurationViewModel : ViewModel() {

    private val remoteConfigurationRepository: RemoteConfigurationRepository by lazy { RemoteConfigurationRepository() }
    val remoteConfiguration: LiveData<Boolean> = remoteConfigurationRepository.remoteConfiguration
}