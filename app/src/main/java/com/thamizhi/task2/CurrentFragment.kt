package com.thamizhi.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.thamizhi.task2.R
import com.thamizhi.task2.databinding.FragmentCurrentBinding
import com.thamizhi.task2.viewmodel.CurrentViewmodel

class CurrentFragment : Fragment() {
    lateinit var binding:FragmentCurrentBinding
    private val viewmodel:CurrentViewmodel by lazy {
        ViewModelProviders.of(this).get(CurrentViewmodel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_current,container,false)
        binding.viewmodel=viewmodel

        return binding.root
    }
}