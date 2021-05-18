package com.mattos.aline.filmes.ui.activity

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import com.mattos.aline.filmes.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    //Setup
    private fun setup() {
        setupButtons()
        setupEditText()
    }

    private fun setupEditText() {
        edit_text_search.setOnEditorActionListener { view, id, event ->
            if (id == EditorInfo.IME_ACTION_SEARCH
                || id == EditorInfo.IME_ACTION_DONE
                || event.action == KeyEvent.ACTION_DOWN
                && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                //aqui ele vai pesquisar o que eu terei digitado?
                true
            }
            false
        }
    }

    private fun setupButtons() {

    }
}