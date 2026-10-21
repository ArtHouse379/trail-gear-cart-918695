package daveriholdings.sportinggoods.trailgearcart.data.repository

import daveriholdings.sportinggoods.trailgearcart.data.database.dao.OrderDao
import daveriholdings.sportinggoods.trailgearcart.data.entity.OrderEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class OrderRepository(
    private val orderDao: OrderDao,
    private val coroutineDispatcher: CoroutineDispatcher,
) {
    suspend fun save(orderEntity: OrderEntity): Long {
        return withContext(coroutineDispatcher) {
            orderDao.save(orderEntity)
        }
    }

    fun observeAll(): Flow<List<OrderEntity>> {
        return orderDao.observeAll()
    }
}
