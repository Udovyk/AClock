package udovyk.com.aclock.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "alarms")
data class AlarmEntity(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        var alarmMinutes: String? = null,
        var alarmHours: String? = null,
        var isAlarmEnabled: Boolean = true,
        var mondayCheck: Boolean = true,
        var tuesdayCheck: Boolean = true,
        var wednesdayCheck: Boolean = true,
        var thursdayCheck: Boolean = true,
        var fridayCheck: Boolean = true,
        var saturdayCheck: Boolean = false,
        var sundayCheck: Boolean = false
)