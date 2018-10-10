package udovyk.com.aclock.presentation.alarmlist

import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import udovyk.com.aclock.data.AlarmEntity
import udovyk.com.aclock.presentation.base.BaseViewModel
import udovyk.com.aclock.presentation.base.route.ScreenRouterManager
import javax.inject.Inject

class AlarmListViewModel @Inject constructor(screenRouterManager: ScreenRouterManager) : BaseViewModel(screenRouterManager) {

    val alarmsLiveData: MutableLiveData<List<AlarmEntity>> = MutableLiveData()

    fun getAllAlarms() {
        disposable += dbManager
                .getAllAlarms()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    alarmsLiveData.postValue(it)
                }
    }

}