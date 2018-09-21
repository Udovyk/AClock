package udovyk.com.aclock.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import udovyk.com.aclock.injection.ViewModelFactory
import udovyk.com.aclock.injection.annotation.ViewModelKey
import udovyk.com.aclock.presentation.alarm_list.AlarmListViewModel
import udovyk.com.aclock.presentation.main.MainViewModel

@Module
interface ViewModelBuilder {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlarmListViewModel::class)
    fun bindAlarmListViewModel(viewModel: AlarmListViewModel): ViewModel

}