package org.d3ifcool.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.d3ifcool.myapplication.model.Post
import org.d3ifcool.myapplication.model.User
import org.d3ifcool.myapplication.repository.Repository
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponse4: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponse5: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponse6: MutableLiveData<Response<List<User>>> = MutableLiveData()
    fun getUser() {
        viewModelScope.launch {
            val response = repository.getPostUser()
            myResponse6.value = response
        }
    }
//    fun getPost() {
//        viewModelScope.launch {
//            val response = repository.getPost()
//            myResponse.value = response
//        }
//    }
//
//    fun getPost2(number: Int) {
//        viewModelScope.launch {
//            val response = repository.getPost2(number)
//            myResponse2.value = response
//        }
//    }
//
//    fun getCustomPosts(userId: Int) {
//        viewModelScope.launch {
//            val response = repository.getCustomPost(userId)
//            myResponse4.value = response
//        }
//    }
//
//    fun getCustomPosts2(userId: Int, sort: String, order: String) {
//        viewModelScope.launch {
//            val response = repository.getCustomPost2(userId, sort, order)
//            myResponse4.value = response
//        }
//    }
//
//    fun getCustomPost3(userId: Int, options: Map<String, String>) {
//        viewModelScope.launch {
//            val response = repository.getCustomPost3(userId, options)
//            myResponse5.value = response
//        }
//    }
//
//    fun pushPost(post: Post) {
//        viewModelScope.launch {
//            val response = repository.pushtPost(post)
//            myResponse.value = response
//        }
//    }
//
//    fun pushPost2(userId: Int, int: Int, title: String, body: String) {
//        viewModelScope.launch {
//            val response = repository.pushPost2(userId, int, title, body)
//            myResponse.value = response
//        }
//    }
}