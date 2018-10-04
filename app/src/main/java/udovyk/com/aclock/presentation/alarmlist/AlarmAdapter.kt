package udovyk.com.aclock.presentation.alarmlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_alarm.view.*
import udovyk.com.aclock.R
import udovyk.com.aclock.data.AlarmModel

class AlarmAdapter : RecyclerView.Adapter<AlarmAdapter.ViewHolder>() {
    private val list = mutableListOf<AlarmModel>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTime.text = list.get(position).time
        holder.tvDays.text = list.get(position).days
    }

    fun add(item: AlarmModel) {
        list.add(item)
        notifyDataSetChanged()
    }

    fun allAll(items: List<AlarmModel>) {
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