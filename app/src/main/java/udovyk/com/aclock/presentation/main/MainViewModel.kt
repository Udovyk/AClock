package udovyk.com.aclock.presentation.main

import android.content.SharedPreferences
import udovyk.com.aclock.common.ALARM_LIST_SCREEN
import udovyk.com.aclock.common.SET_ALARM_SCREEN
import udovyk.com.aclock.presentation.base.BaseViewModel
import udovyk.com.aclock.presentation.base.route.ScreenRouterManager
import javax.inject.Inject

class MainViewModel @Inject constructor(screenRouterManager: ScreenRouterManager,
                                        sharedPreferences: SharedPreferences) : BaseViewModel(screenRouterManager) {

    fun setInitScreen() {
        setRootScreen(ALARM_LIST_SCREEN)
    }

    fun openSetAlarmScreen() {
        switchScreen(SET_ALARM_SCREEN)
    }

    fun backToList() {
        setRootScreen(ALARM_LIST_SCREEN)
    }
}