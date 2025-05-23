package com.siri.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siri.navigation.NavScreens
import com.siri.navigation.navigator.Navigator
import com.siri.ui.R


@Composable
fun HomeScreen(
    navigator: Navigator,
    userName: String,
    promotions: List<String>
)  {
    var currentScreen by remember { mutableStateOf("Home") } // สถานะหน้าที่แสดง

    Scaffold(
            bottomBar = {
             BottomNavigationBar(onTabSelected = { screen ->
                 currentScreen = screen  } , navigator)
            }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            // Top Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Hi, $userName", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                IconButton(onClick = { /* Navigate to favorites */ }) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "favorite")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Location Selector
            OutlinedTextField(
                value = "Enter location address",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {navigator.navigateTo("selectLocation") },
                enabled = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Menu Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MenuItem(title = "Taxi", iconRes = R.drawable.ic_taximenu) {
                    navigator.navigateTo("taxi")
                }
                MenuItem(title = "Food", iconRes = R.drawable.ic_foodmenu) {
                    navigator.navigateTo("food")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Promotions
            Text(text = "Promotions", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            LazyColumn {
                items(promotions) { promo ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F3F3))
                    ) {
                        Text(
                            text = promo,
                            modifier = Modifier.padding(16.dp),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MenuItem(title: String, iconRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(width = 100.dp, height = 120.dp)
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun BottomNavigationBar(onTabSelected: (String) -> Unit , navigator: Navigator){
NavigationBar {

    NavigationBarItem(
            selected = false,
            onClick = { navigator.navigateTo(NavScreens.Home.route) },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") }
    )
    NavigationBarItem(
        selected = false,
        onClick = { onTabSelected("Orders") },
        icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Orders") },
        label = { Text("Orders") }
    )
    NavigationBarItem(
        selected = false,
        onClick = { onTabSelected("Inbox") },
        icon = { Icon(Icons.Filled.Email, contentDescription = "Inbox") },
        label = { Text("Inbox") }
    )
    NavigationBarItem(
        selected = false,
        onClick = { onTabSelected("More") },
        icon = { Icon(Icons.Filled.MoreVert, contentDescription = "More") },
        label = { Text("More") }
    )

    }
}