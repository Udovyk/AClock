package udovyk.com.aclock.presentation.main

import android.arch.lifecycle.ViewModelProviders
import android.content.res.ColorStateList
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_END
import android.view.Menu
import android.view.MenuItem
import org.jetbrains.anko.toast
import udovyk.com.aclock.R
import udovyk.com.aclock.bus.RxBus
import udovyk.com.aclock.bus.events.AddAlarmEvent
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

        initUi()
        viewModel.setInitScreen()

        clicks()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menu_item_settings -> toast("opens settings")
            R.id.menu_item_search -> toast("searching..")
        }
        return true
    }

    override fun onBackPressed() {
        binding.run {
            if (binding.bottomAppBar.fabAlignmentMode == FAB_ALIGNMENT_MODE_END) {
                binding.fab.hide()
                viewModel.backToList()
                setBottomAppBarCenterMode()
            } else {
                super.onBackPressed()
            }
        }

    }
    //endregion


    //region fun

    private fun clicks() {
        binding.run {
            fab.setOnClickListener {
                when (bottomAppBar.fabAlignmentMode) {

                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER -> {
                        binding.fab.hide()
                        viewModel.openSetAlarmScreen()
                        setBottomAppBarEndMode()
                    }
                    BottomAppBar.FAB_ALIGNMENT_MODE_END -> {
                        RxBus.publish(AddAlarmEvent())

                        toast("added")
                        binding.fab.hide()
                        viewModel.backToList()
                        setBottomAppBarCenterMode()

                        //todo test

                    }
                }
                //add code for animation
            }
        }
    }

    private fun setBottomAppBarEndMode() {
        Handler().postDelayed({
            binding.run {
                fab.show()
                fab.setImageDrawable(getDrawable(R.drawable.ic_check_white_24dp))
                fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorDone))
                bottomAppBar.replaceMenu(R.menu.menu_set_alarm)
                bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }
        }, 200)
    }

    private fun setBottomAppBarCenterMode() {
        Handler().postDelayed({
            binding.run {
                fab.show()
                fab.setImageDrawable(getDrawable(R.drawable.ic_add_white_24dp))
                fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorAdd))
                bottomAppBar.replaceMenu(R.menu.menu_main)
                bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }, 200)
    }

    private fun initUi() {
        setSupportActionBar(binding.bottomAppBar)
        binding.fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorAdd))
    }
    //endregion
}
