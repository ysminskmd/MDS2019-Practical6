package com.example.shad.fragmenttablet

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : android.support.v4.app.Fragment() {

    private var listItemClickListener: ListItemClickListener? = null

    private lateinit var mData: IntArray

    internal interface ListItemClickListener {
        fun onListItemClick(position: Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            listItemClickListener = activity as ListItemClickListener?
        } catch (ignored: ClassCastException) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mData = arguments?.getIntArray(DATA_KEY) ?: IntArray(0)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        val listAdapter = ListAdapter(listItemClickListener, mData)
        recyclerView.adapter = listAdapter
    }

    companion object {
        private const val DATA_KEY = "data"

        fun newInstance(data: IntArray): ListFragment {
            val args = Bundle()
            args.putIntArray(DATA_KEY, data)

            val fragment = ListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
