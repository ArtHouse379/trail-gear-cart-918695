package daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.cart.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import daveriholdings.sportinggoods.trailgearcart.R
import daveriholdings.sportinggoods.trailgearcart.ui.composable.approot.LocalContentBottomPadding
import daveriholdings.sportinggoods.trailgearcart.ui.theme.LocalDimens
import daveriholdings.sportinggoods.trailgearcart.ui.theme.cardBorderStroke

@Composable
fun CartSummary(
    itemsCount: Int,
    totalPrice: Double,
    modifier: Modifier = Modifier,
    onCompleteOrderButtonClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = dimens.screenPadding,
                end = dimens.screenPadding,
                bottom = dimens.contentSpacing + LocalContentBottomPadding.current,
            ),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Column(modifier = Modifier.padding(dimens.cardPadding)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(R.string.cart_items_count, itemsCount),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Text(
                    text = stringResource(R.string.price_total, totalPrice),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            Button(
                onClick = onCompleteOrderButtonClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(dimens.controlCornerRadius),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                Text(text = stringResource(R.string.button_place_order_label, totalPrice))
            }
        }
    }
}
