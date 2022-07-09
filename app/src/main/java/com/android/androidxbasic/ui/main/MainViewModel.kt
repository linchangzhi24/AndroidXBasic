package com.android.androidxbasic.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {

    private var timer: Timer? = null
    var currentSecond = MutableLiveData<Int>()

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }

    fun startTiming() {
        if (timer == null) {
            currentSecond.value = 0
            timer = Timer()
            val timerTask: TimerTask = object : TimerTask() {
                override fun run() {
                    currentSecond.postValue(currentSecond.value!! + 1)
                }
            }
            timer!!.schedule(timerTask, 0, 1000)
        }
    }

}