package com.siri.navigation

sealed class NavScreens(val route: String) {
    object Splash : NavScreens("splash")
    object Home : NavScreens("home")
    object SelectLocation : NavScreens("selectLocation")
    object Taxi : NavScreens("taxi")
    object Food : NavScreens("food")
    object Orders : NavScreens("orders")
    object Inbox : NavScreens("inbox")
    object More : NavScreens("more")
}
