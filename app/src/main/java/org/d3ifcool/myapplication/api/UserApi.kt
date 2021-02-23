package org.d3ifcool.myapplication.api

import org.d3ifcool.myapplication.model.Post
import org.d3ifcool.myapplication.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("users")
    suspend fun getUser(): Response<List<User>>
}