package com.sidra.local_data_source.IDaoImpl

import androidx.lifecycle.LiveData
import com.sidra.core.Note
import com.sidra.local_data_source.Database.NoteDao

class IDaoImpl : NoteDao{
    override suspend fun insertNote(note: Note) {

    }

    override suspend fun deleteNote(note: Note) {

    }

    override suspend fun updateNote(note: Note) {

    }

    override fun getNotes(): LiveData<List<Note>> {
       return getNotes()
    }
}