package com.example.covidsearchproject.Common

import com.example.covidsearchproject.Interface.RetrofitService
import com.example.covidsearchproject.Retrofit.RetrofitClient

object Common {

    private const val BASE_URL =  "https://covid-19-statistics.p.rapidapi.com/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)

}