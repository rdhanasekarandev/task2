package com.thamizhi.task2.api

import com.apollographql.apollo.ApolloClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

val api=ApolloClient.builder().serverUrl("http://134.209.47.247:4000/graphql").okHttpClient(OkHttpClient.Builder().addInterceptor(Authorize()).build()).build()

class Authorize:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request().newBuilder().addHeader("auth","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjE0OGQ0MTAwLTBiYzAtMTFlYi1iNWQwLTg1MWI5ZDZlYjAxYyIsImVtYWlsIjoiZG9nb29kMUBnbWFpbC5jb20iLCJwaG9uZU51bWJlciI6IjEwMTAxMDEwMTAiLCJpYXQiOjE2MDI0MjA1MTcsImV4cCI6MTYxNzk3MjUxN30.nj9jlb1aFXoKZDI8mTXuQYPeUGtkUatrn9cwUDkEp1Y").build()
        return chain.proceed(request)
    }
}