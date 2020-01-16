package net.azarquiel.hollywood.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Producto::class, Categoria::class), version = 1)
abstract class FosterDB : RoomDatabase() {

    abstract fun productoDao() : ProductoDao
    abstract fun categoriaDao(): CategoriaDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE:  FosterDB? = null

        fun getDatabase(context: Context): FosterDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FosterDB::class.java,
                    "foster"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}