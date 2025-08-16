package com.example.qweasdqwerfd.local_data.data.repository

import com.example.qweasdqwerfd.local_data.data.model.ShoppingListItem
import kotlinx.coroutines.flow.Flow

interface ShoppingListRepository {
    suspend fun insertItem(item: ShoppingListItem)

    suspend fun deleteItem(item: ShoppingListItem)

    fun getAllItems(): Flow<List<ShoppingListItem>>
}