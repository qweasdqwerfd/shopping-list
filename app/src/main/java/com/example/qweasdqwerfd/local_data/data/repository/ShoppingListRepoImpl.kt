package com.example.qweasdqwerfd.local_data.data.repository

import com.example.qweasdqwerfd.local_data.data.dao.ShoppingListDao
import com.example.qweasdqwerfd.local_data.data.model.ShoppingListItem
import kotlinx.coroutines.flow.Flow

class ShoppingListRepoImpl(
    private val dao: ShoppingListDao
): ShoppingListRepository {

    override suspend fun insertItem(item: ShoppingListItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: ShoppingListItem) {
        dao.deleteItem(item)
    }

    override fun getAllItems(): Flow<List<ShoppingListItem>> {
        return dao.getAllItems()
    }

}