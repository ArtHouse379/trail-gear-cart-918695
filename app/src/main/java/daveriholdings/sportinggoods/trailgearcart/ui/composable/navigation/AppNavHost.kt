package daveriholdings.sportinggoods.trailgearcart.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.cart.TOXYECartScreen
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.checkout.TOXYECheckoutScreen
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.home.TOXYEHomeScreen
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.onboarding.TOXYEOnboardingScreen
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.order.TOXYEOrdersScreen
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.productdetails.TOXYEProductDetailsScreen
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.settings.TOXYESettingsScreen
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.splash.TOXYESplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            TOXYESplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            TOXYEOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            TOXYEHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            TOXYEProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            TOXYECartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            TOXYECheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            TOXYEOrdersScreen()
        }

        composable<NavRoute.Settings> {
            TOXYESettingsScreen()
        }
    }
}