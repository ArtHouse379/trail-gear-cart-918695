package daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.productdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import daveriholdings.sportinggoods.trailgearcart.R
import daveriholdings.sportinggoods.trailgearcart.data.model.Product
import daveriholdings.sportinggoods.trailgearcart.ui.composable.approot.LocalContentBottomPadding
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.productdetails.layout.ProductDetailsLayout
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.shared.DataBasedContainer
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.shared.DataEmptyContent
import daveriholdings.sportinggoods.trailgearcart.ui.state.DataUiState
import daveriholdings.sportinggoods.trailgearcart.ui.viewmodel.ProductDetailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TOXYEProductDetailsScreen(
    productId: Int,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailsViewModel = koinViewModel(),
) {
    val productState by viewModel.productDetailsState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.observeProductDetails(productId)
    }

    ProductDetailsScreenContent(
        productState = productState,
        modifier = modifier,
        onAddToCart = viewModel::addProductToCart
    )
}

@Composable
private fun ProductDetailsScreenContent(
    productState: DataUiState<Product>,
    modifier: Modifier = Modifier,
    onAddToCart: () -> Unit,
) {
    Column(modifier = modifier.padding(bottom = LocalContentBottomPadding.current)) {

        DataBasedContainer(
            modifier = Modifier.fillMaxSize(),
            dataState = productState,

            dataPopulated = {
                val data = (productState as DataUiState.Populated<Product>).data

                ProductDetailsLayout(
                    product = data,
                    onAddToCart = onAddToCart,
                )
            },

            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.product_details_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}
