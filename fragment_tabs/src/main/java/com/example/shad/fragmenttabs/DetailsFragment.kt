package com.example.shad.fragmenttabs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content.*

/**
 * A placeholder fragment containing a simple view.
 */
class DetailsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt(ARG_SECTION_NUMBER, 0) ?: 0
        number.text = position.toString()

        val defaultColor = ContextCompat.getColor(this.requireContext(), R.color.colorAccent)
        val color = arguments?.getInt(ARG_COLOR, defaultColor) ?: defaultColor

        view.setBackgroundColor(color)
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_COLOR = "color"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(color: Int, sectionNumber: Int): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putInt(ARG_COLOR, color)
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
