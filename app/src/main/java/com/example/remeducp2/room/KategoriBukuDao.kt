package com.example.remeducp2.room


import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow



interface KategoriBukuDao {
    @Query("SELECT * from tblKategoriBuku WHERE isDeleted = 0 ORDER BY nama ASC")
    fun getAllKategori(): Flow<List<KategoriBuku>>

    @Query("SELECT * from tblKategoriBuku WHERE idKategori = :id")
    fun getKategori(id: Int): Flow<KategoriBuku>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(kategori: KategoriBuku)

    @Update
    suspend fun update(kategori: KategoriBuku)

    @Delete
    suspend fun delete(buku: Buku)
}