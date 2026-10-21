package daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.productdetails.benefits

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import daveriholdings.sportinggoods.trailgearcart.data.model.Benefit
import daveriholdings.sportinggoods.trailgearcart.ui.theme.LocalDimens
import daveriholdings.sportinggoods.trailgearcart.ui.theme.cardBorderStroke

private val BenefitIconSize = 22.dp

@Composable
fun ProductBenefitsCard(benefits: List<Benefit>, modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        ),
        border = cardBorderStroke(color = MaterialTheme.colorScheme.onTertiaryContainer),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.cardPadding),
            verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
        ) {
            benefits.forEach { benefit ->
                ProductBenefitRow(benefit = benefit)
            }
        }
    }
}

@Composable
private fun ProductBenefitRow(benefit: Benefit) {
    val dimens = LocalDimens.current

    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = benefit.icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.size(BenefitIconSize),
        )

        Spacer(modifier = Modifier.width(dimens.itemSpacing))

        Text(
            text = benefit.text,
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
