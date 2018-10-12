package udovyk.com.aclock.presentation.main

import android.content.SharedPreferences
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import udovyk.com.aclock.presentation.base.BaseViewModel
import udovyk.com.aclock.presentation.base.route.ScreenRouterManager
import udovyk.com.aclock.workmanager.AlarmWorker
import java.util.*
import javax.inject.Inject

class AlarmRingingViewModel @Inject constructor(screenRouterManager: ScreenRouterManager,
                                                sharedPreferences: SharedPreferences) : BaseViewModel(screenRouterManager) {



    fun stopAlarm(id: String) {
        WorkManager.getInstance().cancelWorkById(UUID.fromString(id))
    }
}