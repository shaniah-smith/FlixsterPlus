package com.example.flixsterplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(
    private val context: Context,
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.tvTitle.text = movie.title
        holder.tvDescription.text = movie.description

        val imageUrl = POSTER_BASE_URL + movie.posterPath
        Glide.with(context)
            .load(imageUrl)
            .placeholder(R.drawable.poster_placeholder)
            .into(holder.ivPoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}