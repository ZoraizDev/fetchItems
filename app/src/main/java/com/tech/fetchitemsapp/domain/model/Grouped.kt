package com.tech.fetchitemsapp.domain.model

data class GroupedItem(
    val listId: String,
    val itemNames: List<String>,
    val itemCount: Int,
    var isExpanded: Boolean = false // To track the expanded state
)
