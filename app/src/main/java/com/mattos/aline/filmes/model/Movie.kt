package com.mattos.aline.filmes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie (
    @SerializedName("id") var id: Long? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("tagline") var tagline: String? = null,
    @SerializedName("genre") var genre: String? = null
) : Serializable {
}