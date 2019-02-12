package com.example.shad.fragmentanimation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected)

        if (savedInstanceState != null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, FirstFragment()).commit()
        }
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.navigation_home -> {
            replaceFragment(FirstFragment())
            true
        }
        R.id.navigation_dashboard -> {
            replaceFragment(SecondFragment())
            true
        }
        R.id.navigation_notifications -> {
            replaceFragment(ThirdFragment())
            true
        }
        else -> false
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)

        fragmentTransaction.setCustomAnimations(
                R.animator.card_flip_right_in,
                R.animator.card_flip_right_out,
                R.animator.card_flip_left_in,
                R.animator.card_flip_left_out)
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)

        fragmentTransaction.commit()
    }

}
