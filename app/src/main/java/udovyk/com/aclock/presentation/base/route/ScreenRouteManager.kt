package udovyk.com.aclock.presentation.base.route

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.result.ResultListener
import javax.inject.Inject

class ScreenRouterManager @Inject constructor(private val router: Router) : Routable {
    override fun switchScreen(screen: String, data: Any?) {
        if (data == null) {
            router.navigateTo(screen)
        } else {
            router.navigateTo(screen, data)
        }
    }

    override fun replaceScreen(screen: String, data: Any?) {
        if (data == null) {
            router.replaceScreen(screen)
        } else {
            router.replaceScreen(screen, data)
        }
    }

    override fun setRootScreen(screen: String, data: Any?) {
        if (data == null) {
            router.newRootScreen(screen)
        } else {
            router.newRootScreen(screen, data)
        }
    }

    override fun startScreenForResult(screen: String, data: Any?, resultListener: ResultListener, resultCode: Int) {
        if (data == null) {
            router.navigateTo(screen)
        } else {
            router.navigateTo(screen, data)
        }
        router.setResultListener(resultCode, resultListener)
    }

    override fun backWithResult(resultCode: Int, result: Any) {
        router.exitWithResult(resultCode, result)
    }

    override fun removeResultListener(resultCode: Int) {
        router.removeResultListener(resultCode)
    }

    override fun onBackPressed() {
        router.exit()
    }
}