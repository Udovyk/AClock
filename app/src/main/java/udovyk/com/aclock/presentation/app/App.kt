package udovyk.com.aclock.presentation.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import udovyk.com.aclock.injection.component.DaggerAppComponent


class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().bindApplication(this).build()

}