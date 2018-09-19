package udovyk.com.aclock.presentation.main

import android.content.SharedPreferences
import udovyk.com.aclock.presentation.base.BaseViewModel
import udovyk.com.aclock.presentation.base.route.ScreenRouterManager
import javax.inject.Inject

class MainViewModel @Inject constructor(screenRouterManager: ScreenRouterManager,
                                        sharedPreferences: SharedPreferences) : BaseViewModel(screenRouterManager) {
}