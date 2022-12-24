package com.sidra.multimoduleapparch.container

import com.sidra.local_data_source.IDaoImpl.IDaoImpl
import com.sidra.multimoduleapparch.adapter.NoteAdapter
import com.sidra.multimoduleapparch.viewmodel.AppViewModel
import com.sidra.service.Service.ServiceRepo
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Component : KoinComponent {

     val viewModel : AppViewModel by inject()
     val service : ServiceRepo by inject()
     val daoImpl : IDaoImpl by inject()
     val noteAdapter : NoteAdapter by inject()

}