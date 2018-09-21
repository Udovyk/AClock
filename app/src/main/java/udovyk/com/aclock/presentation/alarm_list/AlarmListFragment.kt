package udovyk.com.aclock.presentation.alarm_list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import udovyk.com.aclock.databinding.AlarmListBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseFragment

class AlarmListFragment : BaseFragment() {

    companion object {
        fun newInstance(): AlarmListFragment {
            val fragment = AlarmListFragment()
            return fragment
        }
    }

    //region var
    private lateinit var viewModel: AlarmListViewModel
    private lateinit var binding: AlarmListBinding

    //endregion


    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).getViewModelOfType()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AlarmListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView.text = "well, it works =)"
    }

    //endregion

    //region fun

    //endregion


}