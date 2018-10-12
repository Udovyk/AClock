package udovyk.com.aclock.presentation.main

import android.content.SharedPreferences
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import udovyk.com.aclock.common.ALARM_LIST_SCREEN
import udovyk.com.aclock.common.SET_ALARM_SCREEN
import udovyk.com.aclock.presentation.base.BaseViewModel
import udovyk.com.aclock.presentation.base.route.ScreenRouterManager
import udovyk.com.aclock.workmanager.AlarmWorker
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModel @Inject constructor(screenRouterManager: ScreenRouterManager,
                                        sharedPreferences: SharedPreferences) : BaseViewModel(screenRouterManager) {
    lateinit var alarmClock: OneTimeWorkRequest

    fun startAlarm() {
        /*alarmClock = PeriodicWorkRequest.Builder(AlarmWorker::class.java, 24, TimeUnit.HOURS)
                .addTag("alarm")
                .build()
*/
        alarmClock = OneTimeWorkRequest.Builder(AlarmWorker::class.java)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .addTag("alarm")
                .setInputData(Data.Builder().build())
                .build()
        WorkManager.getInstance().enqueue(alarmClock)
    }

    fun setInitScreen() {
        setRootScreen(ALARM_LIST_SCREEN)
    }

    fun openSetAlarmScreen() {
        switchScreen(SET_ALARM_SCREEN)
    }

    fun backToList() {
        onBackPressed()
    }
}