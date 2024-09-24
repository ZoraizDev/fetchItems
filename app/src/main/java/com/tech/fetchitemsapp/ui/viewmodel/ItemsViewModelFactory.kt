package com.tech.fetchitemsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tech.fetchitemsapp.data.repositry.ItemsRepository

// Factory to provide the ItemsViewModel with the ItemRepository dependency
class ItemsViewModelFactory(private val repository: ItemsRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            return ItemsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}