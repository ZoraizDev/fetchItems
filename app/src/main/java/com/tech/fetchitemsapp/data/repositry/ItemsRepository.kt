package com.tech.fetchitemsapp.data.repositry

import com.tech.fetchitemsapp.data.api.RetrofitInstance
import com.tech.fetchitemsapp.data.model.Item

class ItemsRepository {
    suspend fun getItems(): List<Item> {
        val response = RetrofitInstance.api.getItems()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }
}
