package com.tech.fetchitemsapp.domain.repositry

import com.tech.fetchitemsapp.data.api.RetrofitInstance
import com.tech.fetchitemsapp.data.model.Item

class ItemRepositoryImpl : ItemRepository {
    override suspend fun getItems(): List<Item> {
        val response = RetrofitInstance.api.getItems()  // Fetch response from API
        return if (response.isSuccessful) {
            response.body() ?: emptyList()  // Return the body or an empty list if null
        } else {
            throw Exception("Error fetching items: ${response.code()}")  // Handle error case
        }
    }
}