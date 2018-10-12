package udovyk.com.aclock.presentation.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.media.MediaPlayer
import android.os.Bundle
import udovyk.com.aclock.R
import udovyk.com.aclock.databinding.AlarmRingingBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseActivity

class AlarmRingingActivity : BaseActivity() {

    //region var

    private lateinit var viewModel: AlarmRingingViewModel
    private lateinit var binding: AlarmRingingBinding

    //endregion

    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).getViewModelOfType()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_alarm_ringing)
        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.ringtone)
        mediaPlayer.start()

        binding.btnStop.setOnClickListener {
            viewModel.stopAlarm(intent.extras.getString("id")!!)
        }

    }


}