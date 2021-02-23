package org.d3ifcool.myapplication.api

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import org.d3ifcool.myapplication.utils.Constants.Companion.BASE_URL
import org.d3ifcool.myapplication.utils.Constants.Companion.BASE_URL2
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    //    private val client = OkHttpClient.Builder().apply {
//        addInterceptor(MyInterceptor())
//    }.build()
//            .client(client)
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }
}