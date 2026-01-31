package com.example.remeducp2.room

import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


interface BukuDao {
    @Query("SELECT * FROM tblBuku WHERE isDeleted = 0 ORDER BY judulBuku ASC")
    fun getAllBuku(): Flow<List<Buku>>

    @Query("SELECT * FROM tblBuku WHERE idBuku = :id")
    fun getBuku(id: Int): Flow<Buku>

    @Update
    suspend fun update (buku: Buku)

    @Query("UPDATE tblBUku SET isDeleted = 1 WHERE idBuku = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM tblBuku WHERE idKategoriBuku   = :idKat AND statusPinjam = 1 AND isDeleted =0")
    suspend fun countPinjam(idKat: Int): Int

    @Query("UPDATE tblBuku SET isDeleted = 1 WHERE idKategoriBuku: = idKat")
    suspend fun deleteByKategori(idKat: Int)
}
