package com.example.qweasdqwerfd.presentation.components.screens.add_item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qweasdqwerfd.R
import com.example.qweasdqwerfd.local_data.data.model.AddItem

@Composable
fun UIAddItemScreen(
    item: AddItem,
    onEvent: (AddItemEvent) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .clickable {
                onEvent(AddItemEvent.OnShowEditDialog(item))
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                text = item.name,
                fontSize = 12.sp,
            )
            Checkbox(
                checked = item.isChecked,
                onCheckedChange = {
                    onEvent(AddItemEvent.OnCheckedChange(item.copy(isChecked = it))) //true or false
                }
            )
            IconButton(
                onClick = {
                    onEvent(AddItemEvent.OnDelete(item))
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.trash),
                    contentDescription = "delete"
                )
            }
        }

    }
}