package udovyk.com.aclock.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import udovyk.com.aclock.injection.module.ViewModelBuilder
import udovyk.com.aclock.presentation.app.App
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
        ViewModelBuilder::class]
)
interface AppComponent: AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: App?)
}