package com.blood.jetpackdemo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.blood.jetpackdemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
    }

    fun clickBtn1(view: View) {
        println("runBlocking start")
        runBlocking {
            repeat(8) {
                println("runBlocking $it ${Thread.currentThread().name}")
                delay(1000)
            }
        }
        println("runBlocking end")
    }

    fun clickBtn2(view: View) {
        Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show()
    }

    fun clickBtn3(view: View) {
        println("launch start")
        val job = GlobalScope.launch {
            println("launch ${Thread.currentThread().name}")
        }
        println("launch end ${job.isActive} ${job.isCancelled} ${job.isCompleted}")
    }

    fun clickBtn4(view: View) {
        println("launch start")
        val job = GlobalScope.launch {

            val startTime = System.currentTimeMillis();

            val async1 = GlobalScope.async {
                delay(2000)
                1
            }

            println("launch 11")

            val async2 = GlobalScope.async {
                delay(3000)
                2
            }

            val subTime = System.currentTimeMillis() - startTime;

            println("launch subTime : $subTime")

            println("launch ${async1.await() + async2.await()} subTime : ${System.currentTimeMillis() - startTime}")

            println("launch 111")
        }
        println("launch end")
    }

    fun clickBtn5(view: View) {
//        retrofit<User> {
//            api = ApiServiceManager.apiService.login()
//            onSuccess {
//                Log.e("clickBtn5", "result = ${it.avatar}")
//            }
//            onFail{ msg, _ ->
//                Log.e("clickBtn5", "onFailed = $msg")
//            }
//        }
    }

    suspend fun testSuspendFun() {
        withContext(Dispatchers.IO) {

        }
    }

}