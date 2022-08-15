package com.yunidarifa.githubusers.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteUser::class],
    version = 1
)
abstract class UserDatabase: RoomDatabase() {
    companion object {
        private var INTANCE : UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase? {
            if (INTANCE == null) {
                synchronized(UserDatabase::class) {
                    INTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database").build()
                }
            }
            return INTANCE
        }
    }

    abstract fun favoriteUserDao(): FavoriteUserDao
}