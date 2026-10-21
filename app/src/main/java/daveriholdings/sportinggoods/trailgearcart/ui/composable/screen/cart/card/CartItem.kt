package daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.cart.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import daveriholdings.sportinggoods.trailgearcart.R
import daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.shared.ProductImage
import daveriholdings.sportinggoods.trailgearcart.ui.state.CartItemUiState
import daveriholdings.sportinggoods.trailgearcart.ui.theme.LocalDimens
import daveriholdings.sportinggoods.trailgearcart.ui.theme.cardBorderStroke
import daveriholdings.sportinggoods.trailgearcart.ui.theme.controlBorderStroke
import daveriholdings.sportinggoods.trailgearcart.ui.theme.imageBorder

private val ImageSize = 64.dp
private val StepperButtonSize = 32.dp
private val StepperIconSize = 16.dp

@Composable
fun CartItem(
    item: CartItemUiState,
    modifier: Modifier = Modifier,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    val dimens = LocalDimens.current
    val imageShape = RoundedCornerShape(dimens.cornerRadius)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Row(
            modifier = Modifier.padding(dimens.cardPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProductImage(
                imageUrl = item.productImageUrl,
                modifier = Modifier
                    .size(ImageSize)
                    .clip(imageShape)
                    .imageBorder(imageShape),
            )

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.productTitle,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                Text(
                    text = stringResource(R.string.price, item.productPrice * item.quantity),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Column(horizontalAlignment = Alignment.End) {
                IconButton(
                    onClick = onDeleteClick,
                    modifier = Modifier.size(StepperButtonSize),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.error,
                    ),
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = stringResource(R.string.delete_item_icon_description),
                        modifier = Modifier.size(StepperIconSize),
                    )
                }

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                QuantityPill(
                    quantity = item.quantity,
                    onPlusClick = onPlusClick,
                    onMinusClick = onMinusClick,
                )
            }
        }
    }
}

@Composable
private fun QuantityPill(
    quantity: Int,
    modifier: Modifier = Modifier,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(dimens.controlCornerRadius),
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        border = controlBorderStroke(),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = onMinusClick,
                modifier = Modifier.size(StepperButtonSize),
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = stringResource(
                        R.string.decrease_quantity_icon_description
                    ),
                    modifier = Modifier.size(StepperIconSize),
                )
            }

            Text(
                text = quantity.toString(),
                style = MaterialTheme.typography.labelLarge,
            )

            IconButton(
                onClick = onPlusClick,
                modifier = Modifier.size(StepperButtonSize),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(
                        R.string.increase_quantity_icon_description
                    ),
                    modifier = Modifier.size(StepperIconSize),
                )
            }
        }
    }
}
