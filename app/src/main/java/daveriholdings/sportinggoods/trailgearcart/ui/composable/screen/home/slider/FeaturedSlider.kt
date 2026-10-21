package daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.home.slider

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import daveriholdings.sportinggoods.trailgearcart.R
import daveriholdings.sportinggoods.trailgearcart.data.model.Product
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.shared.ProductImage
import daveriholdings.sportinggoods.trailgearcart.ui.theme.LocalDimens
import daveriholdings.sportinggoods.trailgearcart.ui.theme.cardBorderStroke

@Composable
fun FeaturedSlider(
    products: List<Product>,
    modifier: Modifier = Modifier,
    onProductClick: (productId: Int) -> Unit,
) {
    val pagerState = rememberPagerState { products.size }
    val dimens = LocalDimens.current

    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimens.screenPadding),
        pageSpacing = dimens.contentSpacing,
    ) { page ->
        val product = products[page]

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clickable { onProductClick(product.id) },
            shape = RoundedCornerShape(dimens.cardCornerRadius),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ),
            border = cardBorderStroke(),
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                ProductImage(
                    imageUrl = product.imageUrl,
                    modifier = Modifier.matchParentSize(),
                )

                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(MaterialTheme.colorScheme.scrim.copy(alpha = 0.35f))
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Badge(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    ) {
                        Text(
                            text = stringResource(product.category.titleRes),
                            modifier = Modifier.padding(horizontal = 6.dp),
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }

                    Spacer(modifier = Modifier.height(dimens.itemSpacing))

                    Text(
                        text = product.title,
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Spacer(modifier = Modifier.height(dimens.tightSpacing))

                    Text(
                        text = stringResource(R.string.price, product.price),
                        color = Color.White,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }

                PagerIndicator(
                    pageCount = products.size,
                    currentPage = pagerState.currentPage,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = dimens.cardPadding),
                )
            }
        }
    }
}

@Composable
private fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(pageCount) { page ->
            val isCurrent = page == currentPage

            Box(
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .size(if (isCurrent) 8.dp else 6.dp)
                    .clip(CircleShape)
                    .background(
                        if (isCurrent) Color.White else Color.White.copy(alpha = 0.5f)
                    )
            )
        }
    }
}
