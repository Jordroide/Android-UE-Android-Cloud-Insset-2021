package com.jordroid.android.cloud2021.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jordroid.android.cloud2021.dao.AndroidVersionDao
import com.jordroid.android.cloud2021.model.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao
}

