package com.jordroid.android.cloud2021.remoteConfig.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.jordroid.android.cloud2021.R

class RemoteConfigurationRepository {

    companion object {
        private const val CONFIG_KEY = "config_key"
        private const val TAG = "RemoteConfigurationRepository"
    }

    private val remoteConfig = Firebase.remoteConfig.apply {
        setConfigSettingsAsync(
            FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(0)
                .setFetchTimeoutInSeconds(15)
                .build()
        )
        setDefaultsAsync(R.xml.remote_config_defaults)
        fetchAndActivate().addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                val updated = task.result
                Log.d("RemoteConfigurationRepository", "Config params updated: ${task.result}")
                remoteConfiguration.postValue(updated)
            } else {
                Log.d("RemoteConfigurationRepository", "Config params updated: $task")
            }
        }
    }

    val remoteConfiguration = MutableLiveData<Boolean>()

    init {
        // Get default value
        remoteConfiguration.postValue(remoteConfig[CONFIG_KEY].asBoolean())
    }
}