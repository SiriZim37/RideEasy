package com.siri.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siri.navigation.NavScreens
import com.siri.navigation.navigator.NavigatorImpl
import com.siri.taxi.ui.screens.TaxiBookingScreen
import com.siri.ui.screens.SplashScreen
import com.siri.ui.screens.home.HomeScreen


@Composable
fun MainNavHost(navController: NavHostController = rememberNavController()) {
    val navigator = NavigatorImpl(navController)  // creat instance NavigatorImpl

    NavHost(navController = navController, startDestination = NavScreens.Splash.route) {

        composable(NavScreens.Splash.route) {
            SplashScreen(navigator = navigator)
        }
        composable(NavScreens.Home.route) {
            val userName = "John"
            val promotions = listOf("50% off", "Free delivery", "Buy 1 get 1")
            HomeScreen(navigator = navigator, userName = userName, promotions = promotions)
        }

//        composable(NavScreens.SelectLocation.route) {
//            // select route Home
//        }
//
        composable(NavScreens.Taxi.route) {
            TaxiBookingScreen(navigator = navigator)
        }
        composable(NavScreens.Orders.route) {
            //OrdersScreen(navigator = navigator)
        }

        composable(NavScreens.Inbox.route) {
            //InboxScreen(navigator = navigator)
        }

        composable(NavScreens.More.route) {
           // MoreScreen(navigator = navigator)
        }

    }
}