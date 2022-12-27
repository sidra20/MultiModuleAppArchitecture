package com.sidra.multimoduleapparch.container

import com.sidra.local_data_source.Database.NoteDao
import com.sidra.local_data_source.IDaoImpl.IDaoImpl
import com.sidra.local_data_source.di.providesDao
import com.sidra.local_data_source.di.providesDatabase
import com.sidra.multimoduleapparch.adapter.NoteAdapter
import com.sidra.multimoduleapparch.adapter.PostsAdapter
import com.sidra.multimoduleapparch.viewmodel.AppViewModel
import com.sidra.multimoduleapparch.viewmodel.ViewModelFactory
import com.sidra.netwrok_data_source.ApiService.ApiService
import com.sidra.netwrok_data_source.ApiService.providesPostApiService
import com.sidra.netwrok_data_source.ApiService.providesPostRetrofit
import com.sidra.netwrok_data_source.IApiServiceImpl.IApiServiceImpl
import com.sidra.service.Service.ServiceRepo
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    factory{ IDaoImpl() } bind NoteDao::class

    factory { NoteAdapter() }

    single { providesDatabase(get()) }
    single { providesDao(get()) }

    factory { IApiServiceImpl() } bind ApiService::class
    single { providesPostRetrofit() }
    single { providesPostApiService(get()) }
    factory { PostsAdapter() }
    factory { ServiceRepo(get(),get()) }
    factory { AppViewModel(get()) }
    factory { ViewModelFactory(get()) }

}