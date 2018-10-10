package udovyk.com.aclock.presentation.alarmlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import udovyk.com.aclock.data.AlarmEntity
import udovyk.com.aclock.databinding.AlarmListBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseFragment

class AlarmListFragment : BaseFragment() {
    //todo inject later
    private val adapter = AlarmAdapter()

    companion object {
        private val TAG = "AlarmListFragment"
        fun newInstance(): AlarmListFragment {
            val fragment = AlarmListFragment()
            return fragment
        }
    }

    //region var
    private lateinit var viewModel: AlarmListViewModel
    private lateinit var binding: AlarmListBinding

    val alarmsObsever: Observer<List<AlarmEntity>> = Observer {

        if (it != null && it.isNotEmpty()) {
            adapter.clear()
            adapter.addAll(it)
            Log.d(TAG, ": alarms in db exists, added to adapter")
        }
    }

    //endregion


    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).getViewModelOfType()

        viewModel.alarmsLiveData.observe(this, alarmsObsever)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AlarmListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.getAllAlarms()

    }


    //endregion

    //region fun


    private fun initRecyclerView() {
        binding.run {
            rvAlarms.setHasFixedSize(false)
            rvAlarms.offsetChildrenVertical(5)
            rvAlarms.layoutManager = LinearLayoutManager(context)

            rvAlarms.adapter = adapter
        }
    }

    //endregion


}