package udovyk.com.aclock.presentation.base

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import udovyk.com.aclock.R
import udovyk.com.aclock.common.ALARM_LIST_SCREEN
import udovyk.com.aclock.common.SET_ALARM_SCREEN
import udovyk.com.aclock.injection.ViewModelFactory
import udovyk.com.aclock.presentation.alarmlist.AlarmListFragment
import udovyk.com.aclock.presentation.setalarm.SetAlarmFragment
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    //todo add DbManager

    protected var disposable = CompositeDisposable()

    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(this, R.id.container) {
            override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = null

            override fun createFragment(screenKey: String?, data: Any?): Fragment? =
                when (screenKey) {
                    ALARM_LIST_SCREEN -> AlarmListFragment()
                    SET_ALARM_SCREEN -> SetAlarmFragment()
                    else -> throw Throwable("Unknown screen")
                }

            override fun setupFragmentTransactionAnimation(command: Command?, currentFragment: Fragment?, nextFragment: Fragment?, fragmentTransaction: FragmentTransaction?) {
                fragmentTransaction?.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                super.setupFragmentTransactionAnimation(command, currentFragment, nextFragment, fragmentTransaction)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}