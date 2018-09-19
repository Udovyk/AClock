package udovyk.com.aclock.presentation.base.route

import ru.terrakok.cicerone.result.ResultListener

interface Routable {

    fun switchScreen(screen: String, data: Any? = null)
    fun replaceScreen(screen: String, data: Any? = null)
    fun setRootScreen(screen: String, data: Any? = null)
    fun startScreenForResult(screen: String, data: Any? = null, resultListener: ResultListener, resultCode: Int)
    fun backWithResult(resultCode: Int, result: Any)
    fun removeResultListener(resultCode: Int)

    fun onBackPressed()
}