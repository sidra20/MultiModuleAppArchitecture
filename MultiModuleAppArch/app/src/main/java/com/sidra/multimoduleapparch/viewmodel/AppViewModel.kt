package com.sidra.multimoduleapparch.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidra.core.Note
import com.sidra.service.Service.ServiceRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(private val service : ServiceRepo) : ViewModel() {

    val titleMlv = MutableLiveData<String>()
//    val titleLv : LiveData<String>
//    get() = titleMlv

    val allNotes = service.getNotes
    val getPosts = service.postsLv

    private val msg = MutableLiveData<String>()
    val msgLv : LiveData<String>
    get() = msg

    init {
        viewModelScope.launch {
            service.getNotes
        }

        try {
            viewModelScope.launch (Dispatchers.IO){
                service.getPosts()

            }
            msg.value="Data retieved successfully!"

        }
        catch (e:Exception)
        {
            Log.d("main",""+e.message)
            msg.value="Couldn't retrieve data!"

        }
    }
    fun insert(note: Note) = viewModelScope.launch {
        service.insert(note)
    }

    fun save(){
        try {
            if (titleMlv.value!!.isNotEmpty())
            {

                val title = titleMlv.value!!
                val note = Note(0,title)
                insert(note)
                msg.value="Note Added Successfully!"
                titleMlv.value=""

            }
            else{
                msg.value="Field can't be empty!"

            }

        }
        catch (e: Exception)
        {
            Log.d("viewmodel",""+e.message)
        }

    }
}