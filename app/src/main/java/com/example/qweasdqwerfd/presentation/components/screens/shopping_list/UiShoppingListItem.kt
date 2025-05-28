package com.example.qweasdqwerfd.presentation.components.screens.shopping_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.qweasdqwerfd.R
import com.example.qweasdqwerfd.presentation.instruments.Red

@Preview(showBackground = true)
@Composable
fun UiShoppingListItem() {
    ConstraintLayout(
        modifier = Modifier.padding(
            start = 3.dp,
            top = 18.dp,
            end = 3.dp
        )
    ) {
        val (card, deleteButton, editButton, counter) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },

            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    "List 1",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    "12/12/2023 13.00",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    color = Color.Black
                )
            }
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(deleteButton) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.top)
                    end.linkTo(card.end)

                }
                .padding(end = 5.dp)
                .size(30.dp)
        ) {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Red)
                    .padding(5.dp),
                painter = painterResource(R.drawable.trash),
                tint = Color.White,
                contentDescription = "delete",
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(editButton) {
                    top.linkTo(deleteButton.top)
                    bottom.linkTo(deleteButton.bottom)
                    end.linkTo(deleteButton.start)

                }
                .padding(end = 5.dp)
                .size(30.dp)
        ) {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Green)
                    .padding(7.dp),
                painter = painterResource(R.drawable.pen),
                tint = Color.White,
                contentDescription = "edit",
            )
        }

        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .constrainAs(counter) {
                    top.linkTo(editButton.top)
                    bottom.linkTo(editButton.bottom)
                    end.linkTo(editButton.start)
                }
                .padding(end = 5.dp)
        ) {
            Text(
                text = "15/5",
                color = Color.White,
                modifier = Modifier
                    .background(Red)
                    .padding(
                        top = 3.dp,
                        bottom = 3.dp,
                        start = 5.dp,
                        end = 5.dp
                    ),

                )
        }


    }
}