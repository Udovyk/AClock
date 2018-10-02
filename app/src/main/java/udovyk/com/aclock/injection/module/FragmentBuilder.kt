package udovyk.com.aclock.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import udovyk.com.aclock.presentation.alarm_list.AlarmListFragment
import udovyk.com.aclock.presentation.set_alarm.SetAlarmFragment

@Module
interface FragmentBuilder {

    @ContributesAndroidInjector
    fun contributeAlarmListFragment(): AlarmListFragment

    @ContributesAndroidInjector
    fun contributeSetAlarmFragment(): SetAlarmFragment


}