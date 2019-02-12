package com.example.shad.fragment_lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

private const val TAG = "FLifecycle.Activity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.i(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.i(TAG, "onRestart")
        super.onRestart()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }
}
