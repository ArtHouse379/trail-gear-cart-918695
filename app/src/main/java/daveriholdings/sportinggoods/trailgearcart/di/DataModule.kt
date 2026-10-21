package daveriholdings.sportinggoods.trailgearcart.di

import daveriholdings.sportinggoods.trailgearcart.data.repository.CartRepository
import daveriholdings.sportinggoods.trailgearcart.data.repository.OnboardingRepository
import daveriholdings.sportinggoods.trailgearcart.data.repository.OrderRepository
import daveriholdings.sportinggoods.trailgearcart.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}