package org.d3ifcool.myapplication.repository

import org.d3ifcool.myapplication.api.RetrofitInstance
import org.d3ifcool.myapplication.model.Post
import org.d3ifcool.myapplication.model.User
import retrofit2.Response
import retrofit2.http.POST

class Repository {
    //    suspend fun getPost(): Response<Post> {
//        return RetrofitInstance.api.getPost()
//    }
//
//    suspend fun getPost2(response: Int): Response<Post> {
//        return RetrofitInstance.api.getPost2(response)
//    }
//
//    suspend fun getCustomPost(userId: Int): Response<List<Post>> {
//        return RetrofitInstance.api.getCustomPost(userId)
//    }
//
//    suspend fun getCustomPost2(userId: Int, sort: String, order: String): Response<List<Post>> {
//        return RetrofitInstance.api.getCustomPost2(userId, sort, order)
//    }
//
//    suspend fun getCustomPost3(userId: Int, options: Map<String, String>): Response<List<Post>> {
//        return RetrofitInstance.api.getCustomPost3(userId, options)
//    }
//
//    suspend fun pushtPost(post: Post): Response<Post> {
//        return RetrofitInstance.api.pushPost(post)
//    }
//
//    suspend fun pushPost2(userId: Int, int: Int, title: String, body: String): Response<Post> {
//        return RetrofitInstance.api.pushPost2(userId, int, title, body)
//    }
    suspend fun getPostUser(): Response<List<User>> {
        return RetrofitInstance.api.getUser()
    }
}