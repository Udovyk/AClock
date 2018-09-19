package udovyk.com.aclock.presentation.base

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import udovyk.com.aclock.injection.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected var disposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}