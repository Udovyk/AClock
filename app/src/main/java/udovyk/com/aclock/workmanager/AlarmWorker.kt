package udovyk.com.aclock.workmanager

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.support.annotation.NonNull
import android.support.v4.content.ContextCompat
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import udovyk.com.aclock.R
import udovyk.com.aclock.presentation.main.AlarmRingingActivity
import java.util.concurrent.TimeUnit

class AlarmWorker(
        @NonNull appContext: Context,
        @NonNull workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    companion object {
        private val TAG = AlarmWorker::class.java.simpleName
    }

    @NonNull
    override fun doWork(): Worker.Result {
        Log.d(TAG, "doWork: start")

        initAlarmActivity(applicationContext, inputData.getString("id"))

        Log.d(TAG, "doWork: end")

        return Worker.Result.SUCCESS
    }

    private fun initAlarmActivity(context: Context?, id: String?) {
        Intent(context, AlarmRingingActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
            action = "android.intent.action.VIEW"
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            action = Intent.ACTION_MAIN
            addCategory(Intent.CATEGORY_LAUNCHER)
            putExtra("id", id)
            ContextCompat.startActivity(context!!, this, null)
        }
    }


}