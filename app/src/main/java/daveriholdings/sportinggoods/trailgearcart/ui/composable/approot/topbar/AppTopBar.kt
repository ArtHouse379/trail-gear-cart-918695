package daveriholdings.sportinggoods.trailgearcart.ui.composable.approot.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import daveriholdings.sportinggoods.trailgearcart.R
import daveriholdings.sportinggoods.trailgearcart.ui.composable.approot.matchesAnyRoute
import daveriholdings.sportinggoods.trailgearcart.ui.composable.approot.topbar.canNavigateBackRoutes
import daveriholdings.sportinggoods.trailgearcart.ui.composable.approot.topbar.topBarTitleRes
import daveriholdings.sportinggoods.trailgearcart.ui.composable.navigation.NavRoute
import daveriholdings.sportinggoods.trailgearcart.ui.theme.ControlDivider
import daveriholdings.sportinggoods.trailgearcart.ui.theme.StatusBarIconsFor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    currentDestination: NavDestination?,
    isCartNotEmpty: Boolean,
    onClearCartIconClick: () -> Unit,
    onNavigateBack: () -> Unit,
) {
    val isCartScreen = currentDestination?.hasRoute(route = NavRoute.Cart::class) == true
    val canNavigateBack = currentDestination.matchesAnyRoute(canNavigateBackRoutes)
    val containerColor = MaterialTheme.colorScheme.surfaceContainer

    StatusBarIconsFor(containerColor)

    Column {
        TopAppBar(
            title = {
                Text(
                    text = topBarTitleRes(currentDestination)?.let { stringResource(it) }.orEmpty(),
                    style = MaterialTheme.typography.titleLarge,
                )
            },

            actions = {
                if (isCartScreen) {
                    IconButton(
                        onClick = { onClearCartIconClick() },
                        enabled = isCartNotEmpty,
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.error,
                        ),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(R.string.clear_cart_icon_description),
                            modifier = Modifier.size(22.dp),
                        )
                    }
                }
            },

            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_icon_description),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = containerColor,
                titleContentColor = MaterialTheme.colorScheme.onSurface,
                navigationIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            ),
        )

        ControlDivider()
    }
}
