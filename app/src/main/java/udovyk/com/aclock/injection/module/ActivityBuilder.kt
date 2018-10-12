package udovyk.com.aclock.injection.module

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import udovyk.com.aclock.injection.scope.ActivityScope
import udovyk.com.aclock.presentation.main.AlarmRingingActivity
import udovyk.com.aclock.presentation.main.MainActivity

@Module
interface ActivityBuilder {
    @Binds
    @ActivityScope
    fun provideAppCompatActivity(activity: MainActivity): AppCompatActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    fun contributeAlarmRingingActivity(): AlarmRingingActivity

    @Binds
    @ActivityScope
    fun provideAlarmRingingActivity(activity: AlarmRingingActivity): AppCompatActivity
}