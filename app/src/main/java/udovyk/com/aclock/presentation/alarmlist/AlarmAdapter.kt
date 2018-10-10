package udovyk.com.aclock.presentation.alarmlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_alarm.view.*
import udovyk.com.aclock.R
import udovyk.com.aclock.data.AlarmEntity

class AlarmAdapter : RecyclerView.Adapter<AlarmAdapter.ViewHolder>() {
    private val list = mutableListOf<AlarmEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //TODO REFACTOR according to model
        holder.tvTime.text = list.get(position).alarmHours.toString() + " : " + list.get(position).alarmMinutes.toString()
        //holder.tvDays.text = list.get(position).days
    }

    fun add(item: AlarmEntity) {
        list.add(item)
        notifyDataSetChanged()
    }

    fun addAll(items: List<AlarmEntity>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun deleteItem(pos: Int) {
        list.removeAt(pos)
        notifyDataSetChanged()
    }


    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTime = view.tv_time
        val tvSwitch = view.switch_alarm
        val tvDays = view.tv_days
        val imDelete = view.im_delete
    }
}