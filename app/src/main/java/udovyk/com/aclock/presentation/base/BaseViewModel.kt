package udovyk.com.aclock.presentation.base

import android.arch.lifecycle.ViewModel
import android.content.Context
import io.reactivex.disposables.CompositeDisposable
import udovyk.com.aclock.data.DbManager
import udovyk.com.aclock.presentation.base.route.Routable
import udovyk.com.aclock.presentation.base.route.ScreenRouterManager
import javax.inject.Inject

abstract class BaseViewModel(screenRouterManager: ScreenRouterManager) : ViewModel(), Routable by screenRouterManager {
    var disposable: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var dbManager: DbManager

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}