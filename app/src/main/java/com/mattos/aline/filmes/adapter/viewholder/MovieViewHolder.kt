package com.mattos.aline.filmes.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mattos.aline.filmes.R
import com.mattos.aline.filmes.extensions.then
import com.mattos.aline.filmes.model.Movie

class MovieViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var textView: TextView = itemView.findViewById(R.id.text_recycler)
    var lineView: View = itemView.findViewById(R.id.view_line)


    lateinit var movie: Movie
    var last: Boolean = false
    lateinit var action: () -> Unit

    //Setup Methods
    fun setup(movie: Movie, last: Boolean, action:() -> Unit) {
        this.movie = movie
        this.last = last
        this.action = action

        setupData()
    }

    private fun setupData() {

        textView.setText("${movie?.title}")

        lineView.visibility = last then View.GONE ?: View.VISIBLE
    }

}