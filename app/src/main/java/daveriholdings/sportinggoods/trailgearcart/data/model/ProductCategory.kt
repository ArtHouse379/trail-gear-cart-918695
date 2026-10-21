package daveriholdings.sportinggoods.trailgearcart.data.model

import androidx.annotation.StringRes
import daveriholdings.sportinggoods.trailgearcart.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    CAMPING(R.string.product_category_camping_title),
    HIKING(R.string.product_category_hiking_title),
    CYCLING(R.string.product_category_cycling_title),
    FITNESS(R.string.product_category_fitness_title),
    WATER_SPORTS(R.string.product_category_water_sports_title),
}
