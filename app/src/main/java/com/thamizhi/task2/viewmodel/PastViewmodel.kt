package com.thamizhi.task2.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.toDeferred
import com.thamizhi.task2.GetBookingsQuery
import com.thamizhi.task2.api.api
import kotlinx.coroutines.launch

class PastViewmodel :ViewModel(){
    init {
        viewModelScope.launch {
            val response = api.query(GetBookingsQuery(1, "past")).toDeferred().await()
            Log.d("response","success ${response.data}")
        }
    }
}