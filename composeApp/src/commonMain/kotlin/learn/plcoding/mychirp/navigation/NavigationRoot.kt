package learn.plcoding.mychirp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import learn.plcoding.auth.presentation.navigation.AuthGraphRoutes
import learn.plcoding.auth.presentation.navigation.authGraph

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AuthGraphRoutes.Graph         // not the individual route, but navigation-graph
    ){
        authGraph(
            navController = navController,
            onLoginSuccess = {

            }
        )
    }

}