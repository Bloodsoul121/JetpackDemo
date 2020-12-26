package com.blood.jetpackdemo.live

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blood.jetpackdemo.R

class LiveActivity : AppCompatActivity() {

    companion object {
        const val TAG_LIVE_FRAGMENT = "tag_live_fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live)

        var fragment: LiveFragment? = supportFragmentManager.findFragmentByTag(TAG_LIVE_FRAGMENT) as LiveFragment?
        if (fragment == null) {
            fragment = LiveSingleton.getInstance().liveFragment ?: LiveFragment()
            LiveSingleton.getInstance().liveFragment = fragment
        }
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment, TAG_LIVE_FRAGMENT).commit()
    }
}