package com.sidra.local_data_source.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sidra.core.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDb : RoomDatabase(){

    abstract fun noteDao() : NoteDao
}