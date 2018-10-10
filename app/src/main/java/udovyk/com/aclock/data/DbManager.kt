package udovyk.com.aclock.data

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class DbManager @Inject constructor(private val alarmDao: AlarmDao) {

    val executor: Executor = Executors.newSingleThreadExecutor()

    fun insertAlarm(alarmEntity: AlarmEntity): Completable {
        return Completable.fromAction{
            alarmDao.insertAlarm(alarmEntity)
        }
    }

    fun insertAll(alarmList: List<AlarmEntity>) = alarmDao.insertAll(alarmList)

    fun getAlarmById(id: Int): Flowable<AlarmEntity> = alarmDao.getAlarmById(id)

    fun getCount(): Int = alarmDao.getCount()

    fun getAllAlarms(): Flowable<List<AlarmEntity>> = alarmDao.getAllAlarms()

    fun deleteAlarm(alarmEntity: AlarmEntity) = alarmDao.deleteAlarm(alarmEntity)

    fun deleteAlarmById(id: Int) = alarmDao.deleteAlarmById(id)

    fun deleteAll(): Int = alarmDao.deleteAll()

    fun updateIsAlarmOnById(isAlarmOn: Boolean, id: Int) = alarmDao.updateIsAlarmOnById(isAlarmOn, id)

    fun updateAlarmById(alarmMinutes: String, alarmHours: String, isAlarmOn: Boolean, mondayCheck: Boolean, tuesdayCheck: Boolean, wednesdayCheck: Boolean, thursdayCheck: Boolean, fridayCheck: Boolean, saturdayCheck: Boolean, sundayCheck: Boolean, id: Int) {
        alarmDao.updateAlarmById(alarmMinutes, alarmHours, isAlarmOn, mondayCheck, tuesdayCheck, wednesdayCheck, thursdayCheck, fridayCheck, saturdayCheck, sundayCheck, id)
    }
}