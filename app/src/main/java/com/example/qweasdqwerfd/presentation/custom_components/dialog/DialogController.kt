package com.example.qweasdqwerfd.presentation.custom_components.dialog

import androidx.compose.runtime.MutableState

interface DialogController {
    val dialogTitle: MutableState<String>
    val editableText: MutableState<String>
    val openDialog: MutableState<Boolean>
    val showEditableText: MutableState<Boolean>
    fun onDialogEvent(event: DialogEvent)

}