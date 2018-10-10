package udovyk.com.aclock.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
interface AlarmDao {

//insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlarm(alarmEntity: AlarmEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(alarmList: List<AlarmEntity>)

//get
    @Query("SELECT * FROM alarms WHERE id = :id")
    fun getAlarmById(id: Int): Flowable<AlarmEntity>

    @Query("SELECT COUNT(*) FROM alarms")
    fun getCount(): Int

    @Query("SELECT * FROM alarms")
    fun getAllAlarms(): Flowable<List<AlarmEntity>>

//delete
    @Delete
    fun deleteAlarm(alarmEntity: AlarmEntity)

    @Query("DELETE FROM alarms WHERE id = :id")
    fun deleteAlarmById(id: Int)

    @Query("DELETE FROM alarms")
    fun deleteAll(): Int

//update
    @Query("UPDATE alarms SET isAlarmEnabled = :isAlarmOn WHERE id = :id")
    fun updateIsAlarmOnById(isAlarmOn: Boolean, id: Int)

    @Query("UPDATE alarms SET alarmMinutes = :alarmMinutes, alarmHours = :alarmHours, isAlarmEnabled = :isAlarmOn, mondayCheck = :mondayCheck, tuesdayCheck = :tuesdayCheck, wednesdayCheck = :wednesdayCheck, thursdayCheck = :thursdayCheck, fridayCheck = :fridayCheck, saturdayCheck = :saturdayCheck, sundayCheck = :sundayCheck  WHERE id = :id")
    fun updateAlarmById(alarmMinutes: String, alarmHours: String, isAlarmOn: Boolean,
                        mondayCheck: Boolean, tuesdayCheck: Boolean, wednesdayCheck: Boolean,
                        thursdayCheck: Boolean, fridayCheck: Boolean, saturdayCheck: Boolean, sundayCheck: Boolean, id: Int)


}