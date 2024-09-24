package com.tech.fetchitemsapp.data.api

import com.tech.fetchitemsapp.data.model.Item
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")
    suspend fun getItems(): Response<List<Item>>
}