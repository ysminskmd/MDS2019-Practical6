package com.example.shad.fragmenttabs

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class ViewPagerAdapter(
        fm: FragmentManager,
        private val colors: List<Int>
) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return DetailsFragment.newInstance(colors[position], position + 1)
    }

    override fun getCount(): Int = colors.size

    override fun getPageTitle(position: Int): CharSequence {
        val color = colors[position]
        val hex = Integer.toHexString(color and 0x00FFFFFF)
        return "#" + hex.toUpperCase()
    }
}
