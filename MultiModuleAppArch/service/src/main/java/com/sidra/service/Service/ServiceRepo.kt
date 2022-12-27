package com.sidra.service.Service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sidra.core.Note
import com.sidra.core.modelapi.Post
import com.sidra.local_data_source.Database.NoteDao
import com.sidra.netwrok_data_source.ApiService.ApiService

class ServiceRepo(private val noteDao: NoteDao, private val apiService: ApiService) {

    private val postsMlv = MutableLiveData<Post>()
    val postsLv : LiveData<Post>
        get() = postsMlv

    val getNotes = noteDao.getNotes()

    suspend fun insert(note : Note)
    {
        noteDao.insertNote(note)
    }

    suspend fun getPosts(){
        val result = apiService.getPosts()
        if(result.body()!=null)
        {
            postsMlv.postValue(result.body())

        }
        else{

        }
    }

}