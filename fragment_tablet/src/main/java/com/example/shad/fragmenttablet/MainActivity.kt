package com.example.shad.fragmenttablet

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import java.util.*

private const val KEY_DATA = "data"

class MainActivity : AppCompatActivity(), ListFragment.ListItemClickListener {

    private lateinit var data: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            data = generateData()

            val fragment = ListFragment.newInstance(data)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        } else {
            data = savedInstanceState.getIntArray(KEY_DATA)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(KEY_DATA, data)
    }

    override fun onListItemClick(position: Int) {
        val extras = Bundle()
        val color = data[position]
        extras.putInt(DetailsFragment.COLOR_KEY, color)
        extras.putInt(DetailsFragment.POSITION_KEY, position + 1)

        val detailsFragment = findViewById<View>(R.id.fragment_details_container)
        if (detailsFragment == null) {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtras(extras)

            startActivity(intent)
        } else {
            val fragment = DetailsFragment.newInstance(extras)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_details_container, fragment).commit()
        }
    }

    private fun generateData(): IntArray {
        val rnd = Random()

        return (0..999)
                .map { Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)) }
                .toIntArray()
    }
}
