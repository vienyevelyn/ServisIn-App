package org.umn.servisin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.umn.servisin.datas.ServisDataSource
import org.umn.servisin.ui.screens.BookingConfirmation
// import org.umn.servisin.model.Worker
import org.umn.servisin.ui.screens.CategoryScreen
import org.umn.servisin.ui.screens.HomeScreen
import org.umn.servisin.ui.screens.Login
import org.umn.servisin.ui.screens.WorkerCategory
import org.umn.servisin.ui.screens.WorkerProfile
import org.umn.servisin.ui.screens.SignUp
import org.umn.servisin.ui.screens.SplashScreen1
import org.umn.servisin.ui.screens.SplashScreen2
import org.umn.servisin.ui.screens.SplashScreen3
import org.umn.servisin.ui.screens.BookingPlan

//Untuk pindah screen
@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash1.route
    ) {
        composable(route = Screen.Splash1.route) {
            SplashScreen1(navController = navController)
        }

        composable(route = Screen.Splash2.route) {
            SplashScreen2(navController = navController)
        }

        composable(route = Screen.Splash3.route) {
            SplashScreen3(navController = navController)
        }

        composable(route = Screen.Login.route) {
            Login(navController = navController)
        }

        composable(route = Screen.Signup.route) {
            SignUp(navController = navController)
        }

        composable(route = Screen.Category.route) {
            CategoryScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Worker.route) {
            WorkerCategory(navController = navController)
        }

        composable(
            route = Screen.WorkerProfile.route
        ) { backStackEntry ->

            val workerName = backStackEntry.arguments?.getString("workerName")

            val worker = ServisDataSource.workers.find {
                it.name == workerName
            }

            if (worker != null) {
                WorkerProfile(
                    navController = navController,
                    worker = worker
                )
            }
        }

        composable( route = Screen.BookingPlan.route ) {
            BookingPlan(navController = navController)
        }

        composable( route = Screen.BookingConfirmation.route ) {
            BookingConfirmation(navController = navController)
        }
    }
}
