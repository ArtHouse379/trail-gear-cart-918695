package daveriholdings.sportinggoods.trailgearcart.di

import daveriholdings.sportinggoods.trailgearcart.data.datastore.OnboardingDataStoreManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { OnboardingDataStoreManager(androidContext()) }
}