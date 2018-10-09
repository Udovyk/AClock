package udovyk.com.aclock.presentation.setalarm.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import udovyk.com.aclock.databinding.DateBinding
import udovyk.com.aclock.R
import java.util.*

class DateDialog : DialogFragment(), DatePickerDialog.OnDateSetListener {
    var listener: DatePickerListener? = null
    lateinit var binding: DateBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DataBindingUtil.inflate(activity!!.layoutInflater, R.layout.dialog_date, null, false)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity, this, year, month, day + 1)
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        listener?.onDatePicked(year, month, day)
    }

    companion object {
        val TAG = DateDialog::class.java.simpleName
    }

    interface DatePickerListener {
        fun onDatePicked(year: Int, month: Int, day: Int)
    }
}