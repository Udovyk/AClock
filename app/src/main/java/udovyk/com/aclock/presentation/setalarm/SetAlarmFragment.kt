package udovyk.com.aclock.presentation.setalarm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.rxkotlin.plusAssign
import udovyk.com.aclock.databinding.SetAlarmBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseFragment
import udovyk.com.aclock.presentation.setalarm.dialog.DateDialog
import java.util.*

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

        clicks()


    }


    //endregion

    //region fun

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
                val pickedData = day.toString() + ", " + month.toString()
                binding.tvDate.text = pickedData
            }
        }
        dialog.show(childFragmentManager, DateDialog.TAG)
    }

    private fun listenEvents() {

    }

    //endregion


}