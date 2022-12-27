package com.sidra.multimoduleapparch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sidra.core.Note
import com.sidra.core.modelapi.Post
import com.sidra.core.modelapi.PostItem
import com.sidra.multimoduleapparch.databinding.NoteItemBinding
import com.sidra.multimoduleapparch.databinding.PostItemBinding

class PostsAdapter() : RecyclerView.Adapter<PostsAdapter.MYviewHolder>()
{
    var postsList = ArrayList<PostItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYviewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostItemBinding.inflate(inflater,parent,false)
        val viewObj = MYviewHolder(binding)
        return viewObj    }

    override fun onBindViewHolder(holder: MYviewHolder, position: Int) {
        val posts = postsList[position]
        holder.binding.dataClass=posts

    }
    override fun getItemCount(): Int {
        return postsList.size
    }

    fun updateList(newList : Post){

        postsList.clear()
        postsList.addAll(newList)
        notifyDataSetChanged()

    }

    class MYviewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)
    {}



}