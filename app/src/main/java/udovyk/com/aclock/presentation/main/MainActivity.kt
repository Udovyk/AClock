package udovyk.com.aclock.presentation.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import android.view.Menu
import com.jakewharton.rxbinding2.view.RxView
import udovyk.com.aclock.R
import udovyk.com.aclock.databinding.MainActivityBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseActivity

class MainActivity : BaseActivity() {

    //region var
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainActivityBinding

    //endregion

    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).getViewModelOfType()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setActionBar()
        viewModel.setInitScreen()

        clicks()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //endregion

    //region fun

    private fun clicks() {
        binding.run {
            fab.setOnClickListener {
                bottomAppBar.replaceMenu(R.menu.set_alarm_menu)
                when (bottomAppBar.fabAlignmentMode) {

                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER -> {
                        viewModel.openSetAlarmScreen()
                        bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                        fab.setImageDrawable(getDrawable(R.drawable.ic_check_white_24dp))
                    }
                    BottomAppBar.FAB_ALIGNMENT_MODE_END -> {
                        viewModel.backToList()
                        bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                        fab.setImageDrawable(getDrawable(R.drawable.ic_add_white_24dp))
                    }
                }
                //add code for animation
            }
        }
    }

    private fun setActionBar() {
        val bottomAppBar = binding.bottomAppBar
        bottomAppBar.navigationIcon = null
        setSupportActionBar(bottomAppBar)
    }

    //endregion
}
