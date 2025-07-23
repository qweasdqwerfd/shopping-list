package com.example.roomdb.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdb.roomdb.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory)
) {

    val itemsList = mainViewModel.itemsList.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                value = mainViewModel.newText.value,
                onValueChange = {
                    mainViewModel.newText.value = it
                },
                label = {
                    Text(
                        "Name..."
                    )
                },
                modifier = Modifier
                    .weight(1f),

                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            )
            IconButton(
                onClick = {
                    mainViewModel.insertItem()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add"
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(itemsList.value) { item ->
                ListItem(
                    item = item,

                    onClick = {
                        mainViewModel.nameEntity = it
                        mainViewModel.newText.value = it.name
                    },

                    onClickDelete = {
                        mainViewModel.deleteItem(item)
                    }
                )
            }
        }
    }
}