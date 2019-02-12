package com.example.shad.fragmentbackstackup

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import java.util.*

class MainActivity : AppCompatActivity() {

    private var fragmentNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.addOnBackStackChangedListener { configureDisplayUpButton() }

        if (savedInstanceState == null) {
            val fragment = createFragment()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        popBackStack()
        return true
    }

    private fun configureDisplayUpButton() {
        val canDisplay = supportFragmentManager.backStackEntryCount > 0
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(canDisplay)
    }

    fun clickHome(view: View) {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack(
                    supportFragmentManager.getBackStackEntryAt(0).id,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    fun clickNext(view: View) {
        addFragment()
    }

    fun clickPopTop(view: View) {
        popBackStack()
    }

    private fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    private fun addFragment() {
        val fragment = createFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun createFragment(): Fragment = CustomFragment.getInstance(
            generateColor(),
            ++fragmentNumber
    )

    private fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}
