package com.codingwithze.networkingretrofit.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwithze.networkingretrofit.UpdateNewsActivity
import com.codingwithze.networkingretrofit.databinding.ItemNewsBinding
import com.codingwithze.networkingretrofit.model.ResponseDataNewsItem

class NewsAdapter(var listNews : List<ResponseDataNewsItem>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.binding.titleNews.text = listNews[position].title
        holder.binding.dateNews.text = listNews[position].createdAt
        Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.imgNews)

        holder.binding.btnUpdate.setOnClickListener {
            var edit = Intent(it.context, UpdateNewsActivity::class.java)
            edit.putExtra("update", listNews[position].id)
            it.context.startActivity(edit)
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}