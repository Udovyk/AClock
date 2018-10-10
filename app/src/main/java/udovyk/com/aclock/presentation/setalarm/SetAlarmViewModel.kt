package udovyk.com.aclock.presentation.setalarm

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import udovyk.com.aclock.data.AlarmEntity
import udovyk.com.aclock.presentation.base.BaseViewModel
import udovyk.com.aclock.presentation.base.route.ScreenRouterManager
import javax.inject.Inject

class SetAlarmViewModel @Inject constructor(screenRouterManager: ScreenRouterManager) : BaseViewModel(screenRouterManager) {

    private val TAG = "SetAlarmFragment"

    fun setAlarm(alarmMinutes: String, alarmHours: String) {
        disposable += dbManager.
                insertAlarm(AlarmEntity(alarmMinutes = alarmMinutes, alarmHours = alarmHours))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, { Log.e(TAG, it.message)})
    }


}