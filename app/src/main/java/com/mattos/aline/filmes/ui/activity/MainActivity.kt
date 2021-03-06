package com.mattos.aline.filmes.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.mattos.aline.filmes.R
import com.mattos.aline.filmes.adapter.MovieAdapter
import com.mattos.aline.filmes.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    //Variables
    var listMovies: MutableList<Movie> = mutableListOf()
    lateinit var adapterMovie: MovieAdapter
    private var mTopToolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    //Setup
    private fun setup() {
        toolBar()
        carregaLista()
        setupRecycler()
        setupEditText()
    }

    private fun toolBar() {
        mTopToolbar = findViewById(R.id.my_toolbar)
        setActionBar(mTopToolbar)
    }

    private fun setupEditText() {

        edit_text_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(data: CharSequence?, p1: Int, p2: Int, p3: Int) {
                actionSearch(query = data.toString())
            }
        })

        edit_text_search.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(view)
            }
        }

    }

    private fun setupRecycler() {
        adapterMovie = MovieAdapter { movie ->
            val intent = Intent(this, MovieActivity::class.java)
            intent.putExtra("movie", movie);
            startActivity(intent)
        }

        recycler_movies.layoutManager = LinearLayoutManager(this)
        recycler_movies.adapter = adapterMovie
    }

    //General Methods
    private fun actionSearch(query: String) {
        //TODO: filter from database

        if (query.isEmpty()) {
            layout_message_search.visibility = View.VISIBLE
            adapterMovie.populateData(list = null)
        } else {
            layout_message_search.visibility = View.GONE
            adapterMovie.populateData(list = listMovies.filter { movie -> movie.title!!.contains(other = query, ignoreCase = true) })

        }

    }

    private fun carregaLista() {
        listMovies.add(Movie(id = 0, title = "Aladdin", tagline = "AAAAA", genre = "Romance"))
        listMovies.add(Movie(id = 1, title = "Senhor dos An??is: A Sociedade do Anel", tagline = "BBBBB", genre = "Besteirol"))
        listMovies.add(Movie(id = 2, title = "Senhor dos An??is; As Duas Torres", tagline = "CCCCC", genre = "Com??dia"))
        listMovies.add(Movie(id = 3, title = "A Pequena Sereia", tagline = "DDDDD", genre = "Drama"))
        listMovies.add(Movie(id = 4, title = "Sim Senhor", tagline = "EEEEE", genre = "Fantasia"))
        listMovies.add(Movie(id = 5, title = "Alice no pa??s das maravilhas", tagline = "FFFFF", genre = "Romance"))
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}