package com.example.qweasdqwerfd.presentation.components.screens.add_item

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qweasdqwerfd.presentation.custom_components.dialog.DialogController
import com.example.qweasdqwerfd.presentation.custom_components.dialog.DialogEvent
import com.example.qweasdqwerfd.local_data.data.model.AddItem
import com.example.qweasdqwerfd.local_data.data.repository.AddItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(
    private val repository: AddItemRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(), DialogController {

    var itemsList: Flow<List<AddItem>>? = null

    var addItem: AddItem? = null

    init {
        val listId = savedStateHandle.get<String>("listId")?.toInt()
        itemsList = listId?.let { repository.getAllItemsById(it) }
    }

    var itemText = mutableStateOf("")
        private set

    override var dialogTitle = mutableStateOf("")
        private set

    override var editableText = mutableStateOf("")
        private set

    override var openDialog = mutableStateOf(false)
        private set

    override var showEditableText = mutableStateOf(true)
        private set


    fun onEvent(event: AddItemEvent) {
        when (event) {
            is AddItemEvent.OnItemSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        item = addItem?.id,
                        itemText,

                    )
                }
            }
            is AddItemEvent.OnShowEditDialog -> {
                addItem = event.item
            }
            is AddItemEvent.OnTextChange -> {

            }
            is AddItemEvent.OnDelete -> {

            }
            is AddItemEvent.OnCheckedChange -> {

            }
        }
    }

    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnTextChange -> {
                editableText.value = event.text
            }

            is DialogEvent.OnCancel -> {
                openDialog.value = false
                editableText.value = ""
            }

            is DialogEvent.OnConfirm -> {
                openDialog.value = false
                editableText.value = ""
            }
        }
    }

}