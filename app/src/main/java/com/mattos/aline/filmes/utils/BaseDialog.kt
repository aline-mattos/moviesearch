package com.mattos.aline.filmes.utils

import android.app.Dialog
import android.content.Context
import com.mattos.aline.filmes.app.App

abstract class BaseDialog(context: Context) : Dialog(context, theme){
    val mContext = context

    companion object {
        val theme: Int = com.mattos.aline.filmes.R.style.DialogTheme
        val app: App = App.instance
    }
}