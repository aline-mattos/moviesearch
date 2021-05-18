package com.mattos.aline.filmes.ui.activity

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.mattos.aline.filmes.R
import com.mattos.aline.filmes.adapter.MovieAdapter
import com.mattos.aline.filmes.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    //Variables
    var listMovies: MutableList<Movie> = mutableListOf()
    lateinit var adapterMovie: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
        carregaLista()
    }

    //Setup
    private fun setup() {
        setupRecycler()
        setupEditText()
    }

    private fun setupEditText() {
        edit_text_search.setOnEditorActionListener { view, id, event ->
            if (id == EditorInfo.IME_ACTION_SEARCH) {
                actionSearch(query = edit_text_search.text.toString())
            }
            false
        }
    }

    private fun setupRecycler() {

        adapterMovie = MovieAdapter {


        }


    }

    //General Methods
    private fun actionSearch(query: String) {
        Toast.makeText(this, "TODO: SEARCH $query", Toast.LENGTH_SHORT).show()

        edit_text_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (recycler_movies.visibility == View.GONE) {
                    recycler_movies.visibility = View.VISIBLE
                    layout_message_search.visibility = View.GONE
                }
            }
        })

    }

    private fun carregaLista() {
        listMovies.add(Movie(id = 0, title = "A", tagline = "AAAAA", genre = "Romance"))
        listMovies.add(Movie(id = 1, title = "B", tagline = "BBBBB", genre = "Besteirol"))
        listMovies.add(Movie(id = 2, title = "C", tagline = "CCCCC", genre = "Comédia"))
        listMovies.add(Movie(id = 3, title = "D", tagline = "DDDDD", genre = "Drama"))
        listMovies.add(Movie(id = 4, title = "E", tagline = "EEEEE", genre = "Fantasia"))
        listMovies.add(Movie(id = 5, title = "F", tagline = "FFFFF", genre = "Romance"))
    }
}