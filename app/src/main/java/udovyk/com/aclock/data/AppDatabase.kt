package udovyk.com.aclock.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [AlarmEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun alarmDao(): AlarmDao

}