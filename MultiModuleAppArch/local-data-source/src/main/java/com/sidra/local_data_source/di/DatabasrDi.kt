package com.sidra.local_data_source.di

import android.app.Application
import androidx.room.Room
import com.sidra.local_data_source.Database.AppDb
import com.sidra.local_data_source.Database.NoteDao
import org.koin.dsl.module

fun providesDatabase(application: Application): AppDb =
    Room.databaseBuilder(application, AppDb::class.java, "noteDatabase")
        .fallbackToDestructiveMigration()
        .build()

fun providesDao(db: AppDb):NoteDao = db.noteDao()

//val databaseModule = module {
//    single { providesDatabase(get()) }
//    single { providesDao(get()) }
//}