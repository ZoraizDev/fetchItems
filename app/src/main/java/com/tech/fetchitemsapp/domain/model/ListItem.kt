package com.tech.fetchitemsapp.domain.model

sealed class ListItem {
    data class Header(val listId: String) : ListItem()
    data class Item(val id: Int, val name: String) : ListItem()
}
