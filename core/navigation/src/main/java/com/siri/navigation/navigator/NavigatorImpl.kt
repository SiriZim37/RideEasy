package com.siri.navigation.navigator

import androidx.navigation.NavHostController

class NavigatorImpl(private val navController: NavHostController) : Navigator {
    override fun navigateTo(route: String) {
        navController.navigate(route)
    }
}
