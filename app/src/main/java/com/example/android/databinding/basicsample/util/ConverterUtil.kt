package com.example.android.databinding.basicsample.util

import android.databinding.BindingConversion
import android.view.View

object ConverterUtil {
    @JvmStatic
    fun isZero(number: Int): Boolean {
        return number == 0
    }

    object BindingConverters {

        @BindingConversion
        @JvmStatic
        fun booleanToVisibility(isNotVisible: Boolean): Int {
            return if (isNotVisible) View.GONE else View.VISIBLE
        }
    }
}