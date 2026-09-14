package com.example.flixsterplus

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val description: String,

    @SerializedName("poster_path")
    val posterPath: String
)