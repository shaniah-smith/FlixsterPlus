package com.example.flixsterplus

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import android.content.res.Configuration
import androidx.recyclerview.widget.GridLayoutManager
import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    private val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
    private val NOW_PLAYING_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=$API_KEY"

    private lateinit var rvMovies: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private val movies = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvMovies = findViewById(R.id.rvMovies)
        movieAdapter = MovieAdapter(this, movies)
        val orientation = resources.configuration.orientation
        val spanCount = if (orientation == Configuration.ORIENTATION_LANDSCAPE) 2 else 1
        rvMovies.layoutManager = GridLayoutManager(this, spanCount)
        rvMovies.adapter = movieAdapter

        getNowPlayingMovies()
    }

    private fun getNowPlayingMovies() {
        val client = AsyncHttpClient()
        client.get(NOW_PLAYING_URL, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("MainActivity", "onSuccess for getNowPlayingMovies")
                val movieJsonArray = json.jsonObject.getJSONArray("results")

                for (i in 0 until movieJsonArray.length()) {
                    val movieJson = movieJsonArray.getJSONObject(i)
                    val movie = Gson().fromJson(movieJson.toString(), Movie::class.java)
                    movies.add(movie)
                }

                movieAdapter.notifyDataSetChanged()
            }

            override fun onFailure(statusCode: Int, headers: Headers?, response: String, throwable: Throwable?) {
                Log.e("MainActivity", "onFailure $statusCode: $response", throwable)
            }
        })
    }
}