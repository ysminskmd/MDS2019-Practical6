package com.example.shad.fragmenttabs

import android.graphics.Color
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private lateinit var sectionsPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        sectionsPagerAdapter = ViewPagerAdapter(
                supportFragmentManager,
                generateColors()
        )

        // Set up the ViewPager with the sections adapter.
        container.adapter = sectionsPagerAdapter

        tab.setupWithViewPager(container)
    }

    private fun generateColors(): List<Int> {
        val rnd = Random()
        return (0..9).map { generateColor(rnd) }
    }

    @ColorInt
    private fun generateColor(rnd: Random) = Color.argb(
            255,
            rnd.nextInt(256),
            rnd.nextInt(256),
            rnd.nextInt(256)
    )
}
