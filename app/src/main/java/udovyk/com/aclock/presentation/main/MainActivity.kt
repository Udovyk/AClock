package udovyk.com.aclock.presentation.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
import android.support.design.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_END
import android.support.design.widget.FloatingActionButton
import android.view.Menu
import android.view.MenuItem
import org.jetbrains.anko.toast
import udovyk.com.aclock.R
import udovyk.com.aclock.databinding.MainActivityBinding
import udovyk.com.aclock.ext.getViewModelOfType
import udovyk.com.aclock.presentation.base.BaseActivity

class MainActivity : BaseActivity() {

    //region var
    private var currentFabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainActivityBinding

    val addVisibilityChanged: FloatingActionButton.OnVisibilityChangedListener = object : FloatingActionButton.OnVisibilityChangedListener() {
        override fun onShown(fab: FloatingActionButton?) {
            super.onShown(fab)
        }

        override fun onHidden(fab: FloatingActionButton?) {
            super.onHidden(fab)
            binding.run {
                bottomAppBar.toggleFabAlignment()
                if (currentFabAlignmentMode == FAB_ALIGNMENT_MODE_CENTER) {
                    setCenterMode()
                } else {
                    setEndMode()
                }
                fab?.show()
            }
        }
    }



    //endregion

    //region override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).getViewModelOfType()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.bottomAppBar)

        viewModel.setInitScreen()

        clicks()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
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
            when (currentFabAlignmentMode) {

                FAB_ALIGNMENT_MODE_CENTER -> {
                    super.onBackPressed()
                }
                FAB_ALIGNMENT_MODE_END -> {

                    fab.hide(addVisibilityChanged)
                    invalidateOptionsMenu()
                }
            }
        }
    }

    //endregion

    //region fun

    private fun setCenterMode() {
        binding.run {
            bottomAppBar.replaceMenu(R.menu.menu_set_alarm)
            fab?.setImageDrawable(getDrawable(R.drawable.ic_check_white_24dp))
        }
        viewModel.openSetAlarmScreen()
    }

    private fun setEndMode() {
        binding.run {
            bottomAppBar.replaceMenu(R.menu.menu_main)
            fab?.setImageDrawable(getDrawable(R.drawable.ic_add_white_24dp))
        }
        viewModel.backToList()
    }

    private fun BottomAppBar.toggleFabAlignment() {
        currentFabAlignmentMode = fabAlignmentMode
        fabAlignmentMode = currentFabAlignmentMode.xor(1)
    }

    private fun clicks() {
        binding.run {


            fab.setOnClickListener {
                fab.hide(addVisibilityChanged)
                invalidateOptionsMenu()

                when (currentFabAlignmentMode) {
                    FAB_ALIGNMENT_MODE_CENTER -> {

                    }
                    FAB_ALIGNMENT_MODE_END -> {
                        toast("alarm added")
                    }
                }

            }


        }
    }

    //endregion

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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
            bottomAppBar.toggleAlignment()
            bottomAppBar.replaceMenu(R.menu.menu_set_alarm)
            fab.setImageDrawable(getDrawable(R.drawable.ic_check_white_24dp))
            fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorDone))
            bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        }
    }

    private fun setBottomAppBarCenterMode() {
        binding.run {
            bottomAppBar.toggleAlignment()
            bottomAppBar.replaceMenu(R.menu.menu_main)
            fab.setImageDrawable(getDrawable(R.drawable.ic_add_white_24dp))
            fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorAdd))
            bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }
    }

    fun BottomAppBar.toggleAlignment() {
        val current = fabAlignmentMode
        fabAlignmentMode = current.xor(5)
    }

    private fun setActionBar() {
        val bottomAppBar = binding.bottomAppBar
        bottomAppBar.navigationIcon = null
        setSupportActionBar(bottomAppBar)
        bottomAppBar.animation
        //menu and fab initial values
        // bottomAppBar.replaceMenu(R.menu.menu_main)
        binding.fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.fabColorAdd))
    }
*/
    //endregion
}
