package org.umn.servisin.navigation

//buat simpan layar yang ada
sealed class Screen(val route: String) {
    object Splash1 : Screen("splash_1")
    object Splash2 : Screen("splash_2")

    object Splash3 : Screen("splash_3")
    object Login : Screen("login")

    object Signup : Screen("signup")

    object Category : Screen("category")

    object Home : Screen("home")

    object OurPeople : Screen("our_people")

}