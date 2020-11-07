package com.salimisler.mvvmexp.app.utils.extentions

import androidx.fragment.app.Fragment

fun <T> Class<T>.tag(): String {
    return this::class.java.simpleName
}