package com.jordroid.android.cloud2021.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jordroid.android.cloud2021.chuckNorris.dao.ChuckNorrisDao
import com.jordroid.android.cloud2021.chuckNorris.model.ChuckNorrisRoom
import com.jordroid.android.cloud2021.yourFeature.dao.AndroidVersionDao
import com.jordroid.android.cloud2021.yourFeature.model.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class,
        ChuckNorrisRoom::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao

    abstract fun chuckNorrisDao() : ChuckNorrisDao
}

