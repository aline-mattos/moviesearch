package com.mattos.aline.filmes.ui.activity

import android.app.Activity
import android.os.Bundle
import com.mattos.aline.filmes.R
import com.mattos.aline.filmes.model.Movie
import kotlinx.android.synthetic.main.movie_activity.*

class MovieActivity : Activity() {

    lateinit var movie: Movie

    //Lifecycle methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_activity)
        setup()
    }

    //Setup methods
    private fun setup() {
        movie = intent.getSerializableExtra("movie") as Movie
        setupWebView()
    }

    private fun setupWebView() {
        web_view.loadUrl("https://www.imdb.com/find?s=tt&q=${movie.title}")
    }


}
