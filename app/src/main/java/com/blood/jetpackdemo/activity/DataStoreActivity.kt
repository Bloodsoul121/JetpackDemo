package com.blood.jetpackdemo.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.blood.jetpackdemo.databinding.ActivityDataStoreBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DataStoreActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "DataStoreActivity"
        private val NAME = preferencesKey<String>("username")
    }

    private lateinit var binding: ActivityDataStoreBinding

    private val dataStore = createDataStore("bloodDS")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataStoreBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.write.setOnClickListener { write(NAME, "bloodsoul") }
        binding.read.setOnClickListener { read(NAME) }
    }

    private fun write(key: Preferences.Key<String>, value: String) {
        lifecycleScope.launch {
            dataStore.edit {
                it[key] = value
            }
        }
    }

    private fun read(key: Preferences.Key<String>) {
        lifecycleScope.launch {
            dataStore.data.map {
                it[key] ?: "unknown"
            }.collect {
                Log.i(TAG, "read: $it")
            }
        }
    }

}