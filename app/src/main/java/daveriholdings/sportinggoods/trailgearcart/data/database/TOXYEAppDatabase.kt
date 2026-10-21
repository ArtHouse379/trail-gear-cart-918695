package daveriholdings.sportinggoods.trailgearcart.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import daveriholdings.sportinggoods.trailgearcart.data.database.dao.CartItemDao
import daveriholdings.sportinggoods.trailgearcart.data.database.dao.OrderDao
import daveriholdings.sportinggoods.trailgearcart.data.database.converter.Converters
import daveriholdings.sportinggoods.trailgearcart.data.entity.CartItemEntity
import daveriholdings.sportinggoods.trailgearcart.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TOXYEAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}