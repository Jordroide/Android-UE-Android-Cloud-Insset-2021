package com.jordroid.android.cloud2021.view

import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jordroid.android.cloud2021.databinding.ActivityRecyclerViewBinding
import com.jordroid.android.cloud2021.model.MyObjectForRecyclerView
import com.jordroid.android.cloud2021.model.ObjectDataSample
import com.jordroid.android.cloud2021.viewmodel.AndroidVersionViewModel
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: AndroidVersionAdapter
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var viewModel: AndroidVersionViewModel

    private val androidVersionListObserver = Observer<List<MyObjectForRecyclerView>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AndroidVersionViewModel::class.java]

        // Create the instance of adapter
        adapter = AndroidVersionAdapter { item, view ->
            onItemClick(item, view)
        }

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        binding.addItemButton.setOnClickListener { addRandomAndroidVersion() }
        binding.deleteAllItemButton.setOnClickListener { deleteAndroidVersion() }
    }

    override fun onStart() {
        super.onStart()
        viewModel.androidVersionList.observe(this, androidVersionListObserver)
    }

    override fun onStop() {
        super.onStop()
        viewModel.androidVersionList.observe(this, androidVersionListObserver)
    }

    private fun addRandomAndroidVersion() {
        val random = Random.nextInt(0, 1000)
        viewModel.insertAndroidVersion("Android $random", random, "url:$random")
    }

    private fun deleteAndroidVersion() {
        viewModel.deleteAllAndroidVersion()
    }

    private fun onItemClick(objectDataSample: ObjectDataSample, view: View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, objectDataSample.versionName, Toast.LENGTH_LONG).show()
    }
}
