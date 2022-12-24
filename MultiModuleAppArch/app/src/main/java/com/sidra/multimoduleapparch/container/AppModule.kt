package com.sidra.multimoduleapparch.container

import com.sidra.local_data_source.Database.NoteDao
import com.sidra.local_data_source.IDaoImpl.IDaoImpl
import com.sidra.local_data_source.di.providesDao
import com.sidra.local_data_source.di.providesDatabase
import com.sidra.multimoduleapparch.adapter.NoteAdapter
import com.sidra.multimoduleapparch.viewmodel.AppViewModel
import com.sidra.multimoduleapparch.viewmodel.ViewModelFactory
import com.sidra.service.Service.ServiceRepo
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    factory{ IDaoImpl() } bind NoteDao::class
    factory { ServiceRepo(get()) }
    factory { AppViewModel(get()) }
    factory { ViewModelFactory(get()) }
    factory { NoteAdapter() }

    single { providesDatabase(get()) }
    single { providesDao(get()) }

}