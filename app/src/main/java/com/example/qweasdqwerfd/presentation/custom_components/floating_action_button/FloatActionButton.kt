package com.example.qweasdqwerfd.presentation.custom_components.floating_action_button

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.qweasdqwerfd.R

@Composable
fun FloatActionBar() {
    FloatingActionButton(
        onClick = {},
        containerColor = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Icon(
            painter = painterResource(R.drawable.add_icon),
            contentDescription = null,
            tint = Color.White
        )
    }
}