package com.example.lab_7
//define how we navigate between screens
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FormulaZeroApp() {
    val navController = rememberNavController() //creates object of type nav controller
    NavHost(navController=navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController)
        }
        composable("races"){
            UpcomingRacesScreen(navController)
        }
        composable("drivers"){
            DriversScreen(navController)
        }
    }
}


