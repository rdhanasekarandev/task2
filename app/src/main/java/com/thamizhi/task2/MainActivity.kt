package com.thamizhi.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.thamizhi.task2.controller.AppController
import com.thamizhi.task2.data.Data
import com.thamizhi.task2.databinding.ActivityMainBinding
import com.thamizhi.task2.viewmodel.MainViewmodel
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val viewmodel:MainViewmodel by lazy {
        ViewModelProviders.of(this).get(MainViewmodel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewmodel=viewmodel


        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("CURRENT"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("PAST"))
        binding.tabLayout.tabGravity=TabLayout.GRAVITY_FILL

        val adapter=Adapter(supportFragmentManager)

        binding.viewPager.adapter=adapter

        binding.tabLayout.setOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
               binding.viewPager.currentItem=p0!!.position
            }

        })

        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))

    }

    class Adapter(fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager){
        override fun getItem(position: Int): Fragment {
            return when(position){
                0-> CurrentFragment()
                1-> PastFragment()
                else -> CurrentFragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }

    }
}