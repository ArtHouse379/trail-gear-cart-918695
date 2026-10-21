package daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.order.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import daveriholdings.sportinggoods.trailgearcart.R
import daveriholdings.sportinggoods.trailgearcart.data.entity.OrderEntity
import daveriholdings.sportinggoods.trailgearcart.ui.theme.LocalDimens
import java.time.format.DateTimeFormatter
import java.util.Locale

private val CardDividerWidth = 1.dp

@Composable
fun OrderItem(
    order: OrderEntity,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val dateFormatter = DateTimeFormatter.ofPattern(
        stringResource(R.string.order_date_pattern),
        Locale.ENGLISH,
    )

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimens.contentSpacing),
            verticalAlignment = Alignment.Top,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.order_number, order.orderNumber),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall,
                )

                Text(
                    text = order.timestamp.format(dateFormatter),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                )

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                Text(
                    text = order.description,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                Text(
                    text = stringResource(
                        R.string.order_customer,
                        order.customerFirstName,
                        order.customerLastName,
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = stringResource(R.string.order_customer_email, order.customerEmail),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Text(
                text = stringResource(R.string.price, order.price),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleSmall,
            )
        }

        HorizontalDivider(
            thickness = CardDividerWidth,
            color = MaterialTheme.colorScheme.outlineVariant,
        )
    }
}
