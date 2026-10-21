package daveriholdings.sportinggoods.trailgearcart.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Hiking
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Verified
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(icon = Icons.Filled.Verified, text = "Trail-tested quality"),
    Benefit(icon = Icons.Filled.Security, text = "Reliable warranty"),
    Benefit(icon = Icons.Filled.Hiking, text = "Adventure essentials"),
)
