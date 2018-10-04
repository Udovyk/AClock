package udovyk.com.aclock.presentation.alarmlist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import io.reactivex.rxkotlin.plusAssign
import udovyk.com.aclock.bus.RxBus
import udovyk.com.aclock.bus.events.AddAlarmEvent
import udovyk.com.aclock.data.AlarmModel
import udovyk.com.aclock.databinding.AlarmListBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseFragment

class AlarmListFragment : BaseFragment() {
    //todo inject later
    private val adapter = AlarmAdapter()

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

        disposable += RxBus.listen(AddAlarmEvent::class.java).subscribe{
            Log.d("TEST" , "added")
            adapter.add(AlarmModel("1:00", "mn, fr"))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AlarmListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()



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