package daveriholdings.sportinggoods.trailgearcart

import android.app.Application
import daveriholdings.sportinggoods.trailgearcart.di.dataModule
import daveriholdings.sportinggoods.trailgearcart.di.dispatcherModule
import daveriholdings.sportinggoods.trailgearcart.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class TOXYEApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@TOXYEApplication)
            modules(appModules)
        }
    }
}
