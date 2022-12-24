package com.sidra.multimoduleapparch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sidra.service.Service.ServiceRepo

class ViewModelFactory(private val serviceRepo: ServiceRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppViewModel(serviceRepo)as T
    }
}