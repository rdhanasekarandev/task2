package com.thamizhi.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.thamizhi.task2.controller.AppController
import com.thamizhi.task2.data.Data
import com.thamizhi.task2.databinding.FragmentPastBinding
import com.thamizhi.task2.viewmodel.PastViewmodel

class PastFragment : Fragment() {
    lateinit var binding:FragmentPastBinding
    private val viewmodel:PastViewmodel by lazy {
        ViewModelProviders.of(this).get(PastViewmodel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_past,container,false)
        binding.viewmodel=viewmodel


        val controller= AppController()

        binding.epoxyRecyclerView.setController(controller)

        controller.setData(Data.tests)

        return binding.root
    }
}