package udovyk.com.aclock.presentation.set_alarm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import udovyk.com.aclock.databinding.SetAlarmBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseFragment

class SetAlarmFragment : BaseFragment() {

    companion object {
        fun newInstance(): SetAlarmFragment {
            val fragment = SetAlarmFragment()
            return fragment
        }
    }

    //region var
    private lateinit var viewModel: SetAlarmViewModel
    private lateinit var binding: SetAlarmBinding

    //endregion


    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).getViewModelOfType()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SetAlarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    //endregion

    //region fun

    //endregion


}