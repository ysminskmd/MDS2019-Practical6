package com.example.shad.fragment_lifecycle

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val TAG = "FLifecycle.Fragment"

class CustomFragment : Fragment() {

    override fun onAttach(context: Context?) {
        Log.i(TAG, "onAttach")
        super.onAttach(context)

        //Вызывается, когда фрагмент связывается с activity (ему передается объект Activity).
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //Вызывается для создания иерархии view, связанной с фрагментом.

        Log.i(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)

        //Вызывается, когда метод onCreate(), принадлежащий activity, возвращает управление.
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

    override fun onDestroyView() {
        Log.i(TAG, "onDestroyView")
        super.onDestroyView()

        //Вызывается при удалении иерархии view, связанной с фрагментом.
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i(TAG, "onDetach")
        super.onDetach()

        //Вызывается при разрыве связи фрагмента с activity.
    }
}
