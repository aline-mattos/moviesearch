package com.mattos.aline.filmes.extensions

infix fun <T> Boolean.then(param: T): T? = if (this) param else null
