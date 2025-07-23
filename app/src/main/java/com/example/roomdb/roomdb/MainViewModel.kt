package com.example.roomdb.roomdb

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.roomdb.roomdb.data.MainDB
import com.example.roomdb.roomdb.data.NameEntity
import kotlinx.coroutines.launch

class MainViewModel(val database: MainDB) : ViewModel() {

    val itemsList = database.dao.getAllItems()
    var newText = mutableStateOf("")
    var nameEntity: NameEntity? = null

    fun insertItem() = viewModelScope.launch {
        val nameItem = nameEntity?.copy(name = newText.value)
            ?: NameEntity(name = newText.value)

        database.dao.insertItem(nameItem)

        nameEntity = null
        newText.value = ""
    }

    fun deleteItem(item: NameEntity) = viewModelScope.launch {
        database.dao.deleteItem(item)
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")

            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).dataBase
                return MainViewModel(database) as T
            }
        }
    }

}