package com.example.remeducp2.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Buku::class, KategoriBuku::class], version = 1, exportSchema = false)
abstract class DatabasePerpus : RoomDatabase(){
    abstract fun bukuDao(): BukuDao
    abstract fun kategoriDao(): KategoriBukuDao

    fun getDatabase(context: Context): DatabasePerpus {
        return Instance ?: synchronized(lock = this) {
            Room.databaseBuilder(
                context, klass = DatabasePerpus::class.java,
                name = "produk_database")
                .build().also { Instance=it }
        })

    }

}

