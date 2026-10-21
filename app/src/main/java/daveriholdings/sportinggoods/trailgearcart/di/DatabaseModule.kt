package daveriholdings.sportinggoods.trailgearcart.di

import androidx.room.Room
import daveriholdings.sportinggoods.trailgearcart.data.database.TOXYEAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "toxye_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = TOXYEAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<TOXYEAppDatabase>().cartItemDao() }

    single { get<TOXYEAppDatabase>().orderDao() }
}