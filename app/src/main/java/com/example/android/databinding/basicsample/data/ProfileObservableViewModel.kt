package com.example.android.databinding.basicsample.data

import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.example.android.databinding.basicsample.util.ObservableViewModel
import society.doscon.com.binddata.BR

class ProfileObservableViewModel : ObservableViewModel() {
    var name = ObservableField("LOOO")
    val lastName = ObservableField("Lovelace")
    val likes =  ObservableInt(0)

    fun onLike() {
        likes.increment()
        // You control when the @Bindable properties are updated using `notifyPropertyChanged()`.
        notifyPropertyChanged(BR.popName)
        notifyPropertyChanged(BR.pop)
    }

    @Bindable
    fun getPop(): Popularity {
        return likes.get().let {
            when {
                it > 9 -> Popularity.STAR
                it > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        }
    }

    @Bindable
    fun getPopName(): String {
        return likes.get().let {
            when {
                it > 9 -> "STAR"
                it > 4 -> "POPULAR"
                else -> "NORMAL"
            }
        }
    }

}

/**
 * As an alternative, the @Bindable attribute can be replaced with an
 * `ObservableField`. In this case 'popularity' is an `ObservableField` which has to be computed when
 * `likes` change.
 */
class ProfileObservableFieldsViewModel : ViewModel() {
    val name = ObservableField("Ada000")
    val lastName = ObservableField("Lovelace")
    val likes =  ObservableInt(0)

    // popularity is exposed as an ObservableField instead of a @Bindable property.
    val popularity = ObservableField<Popularity>(Popularity.NORMAL)

    fun onLike() {
        likes.set(likes.get() + 1)

        popularity.set(likes.get().let {
            if (it > 9) Popularity.STAR
            if (it > 4) Popularity.POPULAR
            Popularity.NORMAL
        })
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}

private fun ObservableInt.increment() {
    set(get() + 1)
}