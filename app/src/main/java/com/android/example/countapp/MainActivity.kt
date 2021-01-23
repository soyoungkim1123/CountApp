package com.android.example.countapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.android.example.countapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply{
            countBox.text = count.toString()
            toastBox.setOnClickListener{ Toast.makeText(this@MainActivity, "Hello $count", Toast.LENGTH_SHORT).show() }
            countUpBox.setOnClickListener { countUP() }
            countDownBox.setOnClickListener { countDown() }
        }
    }

    private fun countUP() {
        count += 1
        binding.countBox.text = count.toString()
    }

    private fun countDown() {
        count -= 1
        binding.countBox.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.let{
            count = it.get("count") as Int
            binding.countBox.text = count.toString()
        }
    }
}