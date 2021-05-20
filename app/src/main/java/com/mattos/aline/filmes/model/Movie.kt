package com.mattos.aline.filmes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Movie (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id: Long? = null,
    @ColumnInfo(name = "title")
    @SerializedName("title") var title: String? = null
) : Serializable {
}