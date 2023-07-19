package com.exequielvr.myappsprint

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ItemsEntity::class, ItemsDetailEntity::class], version = 1,
    exportSchema = false
)
abstract class ItemsDatabase : RoomDatabase() {

    abstract fun getItemsDao(): ItemsDao

    companion object {
        @Volatile
        private var
                INSTANCE: ItemsDatabase? = null

        fun getDataBase(context: Context): ItemsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java, "items_db"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}