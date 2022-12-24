package com.sidra.local_data_source.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sidra.core.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note : Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM note")
    fun getNotes() : LiveData<List<Note>>

}