package udovyk.com.aclock.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import udovyk.com.aclock.presentation.alarmlist.AlarmListFragment
import udovyk.com.aclock.presentation.setalarm.SetAlarmFragment

@Module
interface FragmentBuilder {

    @ContributesAndroidInjector
    fun contributeAlarmListFragment(): AlarmListFragment

    @ContributesAndroidInjector
    fun contributeSetAlarmFragment(): SetAlarmFragment


}