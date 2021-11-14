package com.jordroid.android.cloud2021.yourFeature.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordroid.android.cloud2021.chuckNorris.view.ChuckNorrisActivity
import com.jordroid.android.cloud2021.databinding.ActivityMainBinding
import com.jordroid.android.cloud2021.remoteConfig.view.RemoteConfigurationActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainButtonActivityIntent.setOnClickListener {
            goToActivityIntent()
        }

        binding.mainButtonRecyclerView.setOnClickListener { goToRecyclerView() }

        binding.mainButtonActivityStrings.setOnClickListener { goToString() }

        binding.mainButtonActivityResource.setOnClickListener { goToResources() }

        binding.mainButtonActivityValuesLand.setOnClickListener { goToValuesLand() }

        binding.mainButtonActivityRetrofit.setOnClickListener { goToRetrofit() }

        binding.mainButtonActivityRemote.setOnClickListener { goToRemote() }

        binding.mainButtonActivityPermission.setOnClickListener { goToPermission() }
    }

    private fun goToActivityIntent() {
        startActivity(Intent(this, FirstActivity::class.java))
    }

    private fun goToRecyclerView() {
        startActivity(Intent(this, RecyclerViewActivity::class.java))
    }

    private fun goToString() {
        startActivity(Intent(this, StringsActivity::class.java))
    }

    private fun goToResources() {
        startActivity(Intent(this, ResourceActivity::class.java))
    }

    private fun goToValuesLand() {
        startActivity(Intent(this, ValuesLandActivity::class.java))
    }

    private fun goToRetrofit() {
        startActivity(Intent(this, ChuckNorrisActivity::class.java))
    }

    private fun goToRemote() {
        startActivity(Intent(this, RemoteConfigurationActivity::class.java))
    }

    private fun goToPermission() {
        startActivity(Intent(this, PermissionActivity::class.java))
    }
}