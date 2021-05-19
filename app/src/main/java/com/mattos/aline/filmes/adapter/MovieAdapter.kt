package com.mattos.aline.filmes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mattos.aline.filmes.R
import com.mattos.aline.filmes.adapter.viewholder.MovieViewHolder
import com.mattos.aline.filmes.model.Movie

class MovieAdapter(private val action: (Movie) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_movie, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        require(holder is MovieViewHolder)

        holder.apply {
            setup(movie = movies[position], last = position == movies.size - 1)
            itemView.setOnClickListener {
                action.invoke(movies[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun populateData(list: List<Movie>?) {
        movies.clear()

        if (list != null) {
            movies.addAll(list)
        }

        notifyDataSetChanged()
    }
}