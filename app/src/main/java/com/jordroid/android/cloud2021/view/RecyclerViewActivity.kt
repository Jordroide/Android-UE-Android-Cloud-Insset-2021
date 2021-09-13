package com.jordroid.android.cloud2021.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jordroid.android.cloud2021.databinding.ActivityRecyclerViewBinding
import com.jordroid.android.cloud2021.model.ObjectDataSample

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: AndroidVersionAdapter
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the instance of adapter
        adapter = AndroidVersionAdapter()

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())
    }

    private fun generateFakeData(): ArrayList<ObjectDataSample> {
        return arrayListOf(
            ObjectDataSample("Android Lollipop", 5),
            ObjectDataSample("Android Marshmallow", 6),
            ObjectDataSample("Android Nougat", 7),
            ObjectDataSample("Android Oreo", 8),
            ObjectDataSample("Android Pie", 9),
            ObjectDataSample("Android Q", 10),
            ObjectDataSample("Android R", 11),
            ObjectDataSample("Android S", 12)
        )
    }
}
