package udovyk.com.aclock.presentation.base

import android.arch.lifecycle.ViewModel
import udovyk.com.aclock.presentation.base.route.Routable
import udovyk.com.aclock.presentation.base.route.ScreenRouterManager

abstract class BaseViewModel(screenRouterManager: ScreenRouterManager) : ViewModel(), Routable by screenRouterManager{
}