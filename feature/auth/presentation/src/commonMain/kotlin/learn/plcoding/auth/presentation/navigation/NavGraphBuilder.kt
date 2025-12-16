package learn.plcoding.auth.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import learn.plcoding.auth.presentation.register.RegisterRoot
import learn.plcoding.auth.presentation.registerSuccess.RegisterSuccessRoot

fun NavGraphBuilder.authGraph(
    navController: NavController,
    onLoginSuccess: (String) -> Unit
) {
    navigation<AuthGraphRoutes.Graph>(
        startDestination = AuthGraphRoutes.Register
    ){
        composable<AuthGraphRoutes.Register> {
            RegisterRoot(
                onRegisterSuccess = {
                    navController.navigate(AuthGraphRoutes.RegisterSuccess(it))
                }
            )
        }
        composable<AuthGraphRoutes.RegisterSuccess> {
            RegisterSuccessRoot()
        }
    }

}