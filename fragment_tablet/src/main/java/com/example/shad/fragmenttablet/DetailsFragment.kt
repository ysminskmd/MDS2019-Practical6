package com.example.shad.fragmenttablet

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content.*

class DetailsFragment : android.support.v4.app.Fragment() {

    private var backgroundColor: Int = Color.BLACK
    private var position: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { arguments ->
            backgroundColor = arguments.getInt(COLOR_KEY, backgroundColor)
            position = arguments.getInt(POSITION_KEY, position)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setBackgroundColor(backgroundColor)
        number.text = position.toString()
    }

    companion object {

        internal const val COLOR_KEY = "color"
        internal const val POSITION_KEY = "position"

        fun newInstance(extras: Bundle?): Fragment {
            val fragment = DetailsFragment()
            fragment.arguments = extras

            return fragment
        }
    }
}
