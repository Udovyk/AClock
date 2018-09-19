package udovyk.com.aclock.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import udovyk.com.aclock.presentation.alarm_list.AlarmListFragment

@Module
interface FragmentBuilder {

    @ContributesAndroidInjector
    fun contributeAlarmListFragment(): AlarmListFragment


}