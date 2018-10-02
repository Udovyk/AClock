package udovyk.com.aclock.presentation.main

import android.arch.lifecycle.ViewModelProviders
import android.content.res.ColorStateList
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import android.view.Menu
import android.view.MenuItem
import org.jetbrains.anko.toast
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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menu_settings -> toast("opens settings")
            R.id.menu_search -> toast("searching..")
        }
        return true
    }

    override fun onBackPressed() {
        binding.run {
            when (bottomAppBar.fabAlignmentMode) {

                BottomAppBar.FAB_ALIGNMENT_MODE_CENTER -> {
                    super.onBackPressed()
                }
                BottomAppBar.FAB_ALIGNMENT_MODE_END -> {
                    viewModel.backToList()
                    setBottomAppBarCenterMode()
                }
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
                        viewModel.openSetAlarmScreen()
                        setBottomAppBarEndMode()
                    }
                    BottomAppBar.FAB_ALIGNMENT_MODE_END -> {
                        viewModel.backToList()
                        toast("alarm added")
                        setBottomAppBarCenterMode()
                    }
                }
                //add code for animation
            }
        }
    }

    private fun setBottomAppBarEndMode() {
        binding.run {
            bottomAppBar.replaceMenu(R.menu.set_alarm_menu)
            bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            fab.setImageDrawable(getDrawable(R.drawable.ic_check_white_24dp))
            fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorDone))
        }
    }

    private fun setBottomAppBarCenterMode() {
        binding.run {
            bottomAppBar.replaceMenu(R.menu.menu_main)
            bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            fab.setImageDrawable(getDrawable(R.drawable.ic_add_white_24dp))
            fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorAdd))
        }
    }

    private fun setActionBar() {
        val bottomAppBar = binding.bottomAppBar
        bottomAppBar.navigationIcon = null
        setSupportActionBar(bottomAppBar)
        //menu and fab initial values
        // bottomAppBar.replaceMenu(R.menu.menu_main)
        binding.fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorAdd))
    }

    //endregion
}
