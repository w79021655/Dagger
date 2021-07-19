package com.dagger.sample.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dagger.sample.MyApplication
import com.dagger.sample.R
import com.dagger.sample.model.Users
import com.dagger.sample.utils.SharedPrefUtil
import com.dagger.sample.utils.ViewModelFactory
import com.dagger.sample.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var sharedPrefUtil: SharedPrefUtil
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: MainViewModel
    private var mUsers: Users? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (this@MainActivity.application as MyApplication).appComponent.inject(this)

        findViewById<Button>(R.id.button).setOnClickListener {
            fetchUsers()
        }

        setupViewModel()
        setupObserver()
        fetchUsers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private fun fetchUsers() {
        viewModel.fetchUsers(20, 0)
    }

    private fun setupObserver() {
        viewModel.getUsers().observe(this, {
            if (it.isNotEmpty()) {
                mUsers = it
            }
        })
    }
}