package com.sidra.service.Service

import com.sidra.core.Note
import com.sidra.local_data_source.Database.NoteDao

class ServiceRepo(private val noteDao: NoteDao) {

    val getNotes = noteDao.getNotes()

    suspend fun insert(note : Note)
    {
        noteDao.insertNote(note)
    }

}