package com.android.androidxbasic.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.androidxbasic.R
import com.android.androidxbasic.databinding.ActivityMainBinding
import com.android.androidxbasic.views.BottomDialogFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnOpenBottomDialog.setOnClickListener {
            var bottomDialogFragment = BottomDialogFragment()
            bottomDialogFragment.show(supportFragmentManager, null)
        }

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        mainViewModel.currentSecond.observe(this) {
//            // TODO it
//        }
//        mainViewModel.startTiming()
    }
}