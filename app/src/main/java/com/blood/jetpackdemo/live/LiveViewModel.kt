package com.blood.jetpackdemo.live

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/*
 *  @项目名：  JetpackDemo 
 *  @包名：    com.blood.jetpackdemo.live
 *  @文件名:   LiveViewModel
 *  @创建者:   bloodsoul
 *  @创建时间:  2020/12/26 11:19
 *  @描述：    TODO
 */
class LiveViewModel : ViewModel() {

    init {
        println("$this init")
    }

    override fun onCleared() {
        super.onCleared()
        println("$this onCleared")

        data.value = 123
    }

    val data = MutableLiveData<Int>()

}