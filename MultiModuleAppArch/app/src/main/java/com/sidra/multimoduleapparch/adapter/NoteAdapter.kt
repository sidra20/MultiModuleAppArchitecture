package com.sidra.multimoduleapparch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sidra.core.Note
import com.sidra.multimoduleapparch.R
import com.sidra.multimoduleapparch.databinding.NoteItemBinding

class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.MYviewHolder>(){
    private val noteList = ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYviewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NoteItemBinding.inflate(inflater,parent,false)
        val obj = MYviewHolder(binding)
        return obj
    }

    override fun onBindViewHolder(holder: MYviewHolder, position: Int) {
       val notes = noteList[position]
        holder.binding.dataClass=notes
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun updateList(note: List<Note>)
    {
        noteList.clear()
        noteList.addAll(note)
        notifyDataSetChanged()
    }



    class MYviewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)
    {}

}