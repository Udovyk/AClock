package udovyk.com.aclock.presentation.setalarm

import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.rxkotlin.plusAssign
import udovyk.com.aclock.bus.RxBus
import udovyk.com.aclock.bus.events.AddAlarmEvent
import udovyk.com.aclock.common.getMonth
import udovyk.com.aclock.databinding.SetAlarmBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseFragment
import udovyk.com.aclock.presentation.setalarm.dialog.DateDialog
import java.util.*

class SetAlarmFragment : BaseFragment() {

    companion object {
        private val TAG = "SetAlarmFragment"
        fun newInstance(): SetAlarmFragment {
            val fragment = SetAlarmFragment()
            return fragment
        }
    }

    //region var
    private lateinit var viewModel: SetAlarmViewModel
    private lateinit var binding: SetAlarmBinding
    private val calendar = GregorianCalendar(SimpleTimeZone.getDefault())

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
        initCalendar()
        clicks()

        listenEvents()

    }


    //endregion

    //region fun
    private fun listenEvents() {
        disposable += RxBus.listen(AddAlarmEvent::class.java).subscribe {
            Log.d(TAG, ": AddAlarmEvent catch")
            binding.run {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    viewModel.setAlarm(timePicker.minute.toString(), timePicker.hour.toString())
                } else {
                    viewModel.setAlarm(timePicker.currentHour.toString(), timePicker.currentHour.toString())
                }
            }
            Log.d(TAG, ": alarm added to db")

        }

    }

    private fun clicks() {
        binding.run {
            disposable += RxView.clicks(imDate).subscribe{
                showCalendar()
            }
        }
    }

    private fun showCalendar() {
        val dialog = DateDialog()
        dialog.listener = object : DateDialog.DatePickerListener {
            override fun onDatePicked(year: Int, month: Int, day: Int) {
                calendar.set(year, month, day)
                val pickedData = day.toString() + ", " + getMonth(month)
                binding.tvDate.text = pickedData
            }
        }
        dialog.show(childFragmentManager, DateDialog.TAG)
    }

    private fun initCalendar() {
        val pickedData = (calendar.get(Calendar.DAY_OF_MONTH) + 1).toString() + ", " + getMonth(calendar.get(Calendar.MONTH))
        binding.tvDate.text = pickedData
    }



    //endregion


}