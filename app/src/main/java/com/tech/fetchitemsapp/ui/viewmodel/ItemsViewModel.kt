package com.tech.fetchitemsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.fetchitemsapp.data.model.Item
import com.tech.fetchitemsapp.data.repositry.ItemsRepository
import kotlinx.coroutines.launch

class ItemsViewModel(private val repository: ItemsRepository) : ViewModel() {

    // LiveData to expose the grouped list of items to the UI
    private val _groupedItems = MutableLiveData<Map<String, List<String>>>()
    val groupedItems: LiveData<Map<String, List<String>>> = _groupedItems

    // LiveData to expose error messages to the UI
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    // Fetch items from the repository and group them by listId
    fun fetchItems() {
        viewModelScope.launch {
            try {
                val items = repository.getItems()

                // Filter out items with blank or null names
                val filteredItems = items.filter { !it.name.isNullOrBlank() }

                // Group items by listId and create an expandable list
                val grouped = groupItemsByListId(filteredItems)
                _groupedItems.postValue(grouped)
            } catch (e: Exception) {
                _errorMessage.postValue("Failed to fetch items: ${e.message}")
            }
        }
    }

    // Helper function to group items by listId
    private fun groupItemsByListId(items: List<Item>): Map<String, List<String>> {
        return items.groupBy { "List ID: ${it.listId}" } // Group items by listId
            .mapValues { entry -> entry.value.map { it.name ?: "Unnamed Item" }
            } // Map items to their names
    }

}