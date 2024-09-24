package com.tech.fetchitemsapp.domain.repositry

import com.tech.fetchitemsapp.data.model.Item

interface ItemRepository {
    suspend fun getItems(): List<Item>
}