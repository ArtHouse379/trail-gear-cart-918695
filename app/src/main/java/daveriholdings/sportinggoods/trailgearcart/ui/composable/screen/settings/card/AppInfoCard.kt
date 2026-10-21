package daveriholdings.sportinggoods.trailgearcart.ui.composable.screen.settings.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import daveriholdings.sportinggoods.trailgearcart.R
import daveriholdings.sportinggoods.trailgearcart.ui.theme.ControlDivider
import daveriholdings.sportinggoods.trailgearcart.ui.theme.LocalDimens
import daveriholdings.sportinggoods.trailgearcart.ui.theme.cardBorderStroke

@Composable
fun AppInfoCard(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val companyName = stringResource(R.string.toxye_company_name)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Column {
            InfoRow(
                label = stringResource(R.string.settings_screen_app_label),
                value = stringResource(R.string.app_name),
            )

            if (companyName.isNotBlank()) {
                ControlDivider()

                InfoRow(
                    label = stringResource(R.string.settings_screen_company_label),
                    value = companyName,
                )
            }

            ControlDivider()

            InfoRow(
                label = stringResource(R.string.settings_screen_version_label),
                value = stringResource(R.string.toxye_app_version),
            )
        }
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    valueColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    val dimens = LocalDimens.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.cardPadding, vertical = dimens.contentSpacing),
        horizontalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium,
        )

        Text(
            text = value,
            modifier = Modifier.weight(1f),
            color = valueColor,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
