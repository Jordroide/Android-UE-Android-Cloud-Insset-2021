package com.jordroid.android.cloud2021.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jordroid.android.cloud2021.databinding.ItemCustomRecyclerBinding
import com.jordroid.android.cloud2021.model.ObjectDataSample

private val diffItemUtils = object : DiffUtil.ItemCallback<ObjectDataSample>() {

    override fun areItemsTheSame(oldItem: ObjectDataSample, newItem: ObjectDataSample): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ObjectDataSample, newItem: ObjectDataSample): Boolean {
        return oldItem == newItem
    }
}

class AndroidVersionAdapter :
    ListAdapter<ObjectDataSample, AndroidVersionViewHolder>(diffItemUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidVersionViewHolder {
        Log.d("AndroidCloud2021", "new View Holder created")
        return AndroidVersionViewHolder(
            ItemCustomRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AndroidVersionViewHolder, position: Int) {
        Log.d("AndroidCloud2021", "bind new value to position : [$position]")
        holder.bind(getItem(position))
    }
}

class AndroidVersionViewHolder(
    private val binding: ItemCustomRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(objectDataSample: ObjectDataSample) {
        binding.itemRecyclerViewVersionName.text = objectDataSample.versionName
        binding.itemRecyclerViewVersionCode.text = "${objectDataSample.versionCode}"
    }
}
