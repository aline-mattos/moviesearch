package com.mattos.aline.filmes.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mattos.aline.filmes.model.Movie

@Dao
interface RoomMovieDAO {

    @Query("SELECT * FROM Movie")
    fun getAll(): List<Movie>

    @Query("SELECT * FROM Movie WHERE id IN (:movieId)")
    fun loadAllByIds(movieId: IntArray): List<Movie>

    @Query("SELECT * FROM Movie WHERE title LIKE :title LIMIT 1")
    fun findByName(title: String): Movie

    @Insert
    fun insertAll(vararg movies: Movie)

    @Delete
    fun delete(movie: Movie)
}