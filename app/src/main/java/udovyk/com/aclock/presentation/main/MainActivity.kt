package udovyk.com.aclock.presentation.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import android.view.Menu
import kotlinx.android.synthetic.main.fragment_alarm_list.*
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

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu, menu)
        return true
    }

    //endregion

    //region fun
    private fun setActionBar() {
        val bottomAppBar = binding.bottomAppBar
       setSupportActionBar(bottomAppBar)
    }

    //endregion
}
