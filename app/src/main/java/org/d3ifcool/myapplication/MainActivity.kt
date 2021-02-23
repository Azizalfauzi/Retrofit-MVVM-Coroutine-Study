package org.d3ifcool.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3ifcool.myapplication.adapter.JsonDataAdapter
import org.d3ifcool.myapplication.databinding.ActivityMainBinding
import org.d3ifcool.myapplication.model.Post
import org.d3ifcool.myapplication.repository.Repository


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy {
        JsonDataAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        //get 1 data in api
//        viewModel.myResponse2.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Response", response.body()?.userId.toString())
//                Log.d("Response", response.body()?.id.toString())
//                Log.d("Response", response.body()?.title!!)
//                binding.tvResponse.text = response.body()?.body!!
//                Log.d("Response", response.body()?.body!!)
//            } else {
//                Log.d("Response", response.errorBody().toString())
//                binding.tvResponse.text = response.code().toString()
//            }
//        })
        //seacrh dan show data
//        binding.btnAddNumber.setOnClickListener {
//            val numberAdd = binding.inpAddNumber.text.toString()
//            viewModel.getPost2(numberAdd.toInt())
//            viewModel.myResponse2.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    binding.tvResponse.text = response.body().toString()
//                } else {
//                    Log.d("Response", response.errorBody().toString())
//                    binding.tvResponse.text = response.code().toString()
//                }
//            })
//        }
        //search data all and fetch
//        binding.btnAddNumber.setOnClickListener {
//            val numberAdd = binding.inpAddNumber.text.toString()
//            viewModel.getCustomPosts(numberAdd.toInt())
//            viewModel.myResponse3.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    binding.tvResponse.text = response.body().toString()
//                    response.body()?.forEach {
//                        Log.d("Response", it.userId.toString())
//                        Log.d("Response", it.id.toString())
//                        Log.d("Response", it.title)
//                        Log.d("Response", it.body)
//                        Log.d("Response", "--------------")
//                    }
//                } else {
//                    Log.d("Response", response.errorBody().toString())
//                    binding.tvResponse.text = response.code().toString()
//                }
//            })
//        }
        //search data sort dan order (desc) and (asc)
//        binding.btnAddNumber.setOnClickListener {
//            val numberAdd = binding.inpAddNumber.text.toString()
//            viewModel.getCustomPosts2(numberAdd.toInt(), "id", "desc")
//            viewModel.myResponse4.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    binding.tvResponse.text = response.body().toString()
//                    response.body()?.forEach {
//                        Log.d("Response", it.userId.toString())
//                        Log.d("Response", it.id.toString())
//                        Log.d("Response", it.title)
//                        Log.d("Response", it.body)
//                        Log.d("Response", "--------------")
//                    }
//                } else {
//                    Log.d("Response", response.errorBody().toString())
//                    binding.tvResponse.text = response.code().toString()
//                }
//            })
//        }
        //search data with mapping data
//        val options: HashMap<String, String> = HashMap()
//        options["_sort"] = "id"
//        options["_order"] = "desc"
//        binding.btnAddNumber.setOnClickListener {
//            val numberAdd = binding.inpAddNumber.text.toString()
//            viewModel.getCustomPost3(numberAdd.toInt(), options)
//            viewModel.myResponse5.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    binding.tvResponse.text = response.body().toString()
//                    response.body()?.forEach {
//                        Log.d("Response", it.userId.toString())
//                        Log.d("Response", it.id.toString())
//                        Log.d("Response", it.title)
//                        Log.d("Response", it.body)
//                        Log.d("Response", "--------------")
//                    }
//                } else {
//                    Log.d("Response", response.errorBody().toString())
//                    binding.tvResponse.text = response.code().toString()
//                }
//            })
//        }
        //reclerview show
        viewModel.getUser()
        viewModel.myResponse6.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    myAdapter.setData(it)
                }
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
        setupRecylerview()
        //post data with json data and formurlencoded
//        val myPost = Post(2, 2, "Aziz Alfauzi", "Belajar Post Data Semoga success")
//        viewModel.pushPost(myPost)
//        viewModel.pushPost2(3, 3, "Aziz Alfausi", "Android Developer")
//        viewModel.getCustomPosts2(2, "id", "desc")
//        viewModel.getPost()
//        viewModel.myResponse.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Response", response.body().toString())
//                Log.d("Response", response.code().toString())
//                Log.d("Response", response.headers().toString())
//            } else {
//                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
//            }
//        })
//        setupRecylerview()
    }


    private fun setupRecylerview() {
        val recylerView = binding.rvJsonData
        recylerView.adapter = myAdapter
        recylerView.layoutManager = LinearLayoutManager(this)
    }
}