package com.example.sitech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sitech.databinding.ActivityMainBinding
import com.example.sitech.ui.adapters.UserAdapter
import com.example.sitech.ui.viewmodels.UserViewModel
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModel()
    private val adapter: UserAdapter by lazy { UserAdapter(lifecycleScope) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val recycler = binding.recyclerViewUsers
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = adapter

        lifecycleScope.launchWhenStarted {
            userViewModel.usersFlow.onEach {
                userViewModel.getUsers()
            }
        }
    }

}