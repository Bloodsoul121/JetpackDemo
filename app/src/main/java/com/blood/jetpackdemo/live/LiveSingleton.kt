package com.blood.jetpackdemo.live


/*
 *  @项目名：  JetpackDemo 
 *  @包名：    com.blood.jetpackdemo.live
 *  @文件名:   LiveSingleton
 *  @创建者:   bloodsoul
 *  @创建时间:  2020/12/26 11:24
 *  @描述：    TODO
 */
class LiveSingleton private constructor() {

    companion object {
        private val liveSingleton = Holder.liveSingleton
        fun getInstance(): LiveSingleton {
            return liveSingleton
        }
    }

    private object Holder {
        val liveSingleton = LiveSingleton()
    }

    var liveFragment: LiveFragment? = null

}