package udovyk.com.aclock.injection.module

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import udovyk.com.aclock.data.AlarmDao
import udovyk.com.aclock.data.AppDatabase

@Module
class DbModule {
    @Provides
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "udovyk_aclock_db")
                    .build()

    @Provides
    fun providesAlarmDao(database: AppDatabase): AlarmDao = database.alarmDao()

}