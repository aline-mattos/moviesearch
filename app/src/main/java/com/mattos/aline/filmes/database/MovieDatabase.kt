package com.mattos.aline.filmes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mattos.aline.filmes.database.dao.RoomMovieDAO
import com.mattos.aline.filmes.model.Movie


@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getRoomMovieDAO(): RoomMovieDAO

}


