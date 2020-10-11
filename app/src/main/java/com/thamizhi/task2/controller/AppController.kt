package com.thamizhi.task2.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.thamizhi.task2.bookingItem
import com.thamizhi.task2.data.Test

class AppController :TypedEpoxyController<List<Test>>(){

    override fun buildModels(data: List<Test>?) {

        data!!.forEach {
            bookingItem {
                id(it.id)
                test(it)
            }
        }

    }

}