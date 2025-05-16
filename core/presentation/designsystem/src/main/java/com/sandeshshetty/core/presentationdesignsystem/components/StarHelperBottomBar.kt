package com.sandeshshetty.core.presentationdesignsystem.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.R
import androidx.compose.ui.text.capitalize

/**
 * @author sandeshshetty
 * Created 5/14/25 at {TIME}
 */

@Composable
fun StarHelperBottomBar(
    modifier: Modifier = Modifier,
    currentDestination: String?,
    onItemSelected: (Routes) -> Unit
) {
    val items = listOf(Routes.Home, Routes.Employee, Routes.Sale)
    NavigationBar {
        items.forEach { item->
            NavigationBarItem(
                selected = currentDestination == item.route,
                onClick = { onItemSelected(item) },
                icon = {
                    Icon(
                        imageVector = when(item) {
                            Routes.Home -> Icons.Default.Home
                            Routes.Employee -> Icons.Default.Person
                            else -> Icons.Default.ShoppingCart
                        },
                        contentDescription = null
                    )
                },
                label = { Text(text = item.route.removePrefix("dashboard/").capitalize())  }
            )
        }
    }
}