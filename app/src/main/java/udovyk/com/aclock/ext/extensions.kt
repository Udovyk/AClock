package udovyk.com.aclock.ext

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> ViewModelProvider.getViewModelOfType(): T =
        get(T::class.java)