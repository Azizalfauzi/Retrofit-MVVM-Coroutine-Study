package org.d3ifcool.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.myapplication.R
import org.d3ifcool.myapplication.databinding.ListItemJsonDataBinding
import org.d3ifcool.myapplication.model.Post
import org.d3ifcool.myapplication.model.User

class JsonDataAdapter :
    RecyclerView.Adapter<JsonDataAdapter.JsonDataViewHolder>() {
    inner class JsonDataViewHolder(val recylerviewListItemJsonDataBinding: ListItemJsonDataBinding) :
        RecyclerView.ViewHolder(recylerviewListItemJsonDataBinding.root)

    private var myList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JsonDataViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_json_data,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = myList.size

    override fun onBindViewHolder(holder: JsonDataViewHolder, position: Int) {
        holder.recylerviewListItemJsonDataBinding.tvUserId.text = myList[position].id.toString()
        holder.recylerviewListItemJsonDataBinding.tvId.text = myList[position].name
        holder.recylerviewListItemJsonDataBinding.tvTitle.text = myList[position].username
        holder.recylerviewListItemJsonDataBinding.tvBody.text = myList[position].address.street
    }

    fun setData(newList: List<User>) {
        myList = newList
        notifyDataSetChanged()
    }
}