package com.example.remeducp2.repositori

import androidx.room.Transaction
import com.example.remeducp2.room.Buku
import com.example.remeducp2.room.BukuDao
import com.example.remeducp2.room.KategoriBuku
import com.example.remeducp2.room.KategoriBukuDao
import kotlinx.coroutines.flow.Flow

interface RepositoriPerpus{
    fun getAllKategori(): Flow<List<KategoriBuku>>
    fun getAllBuku(): Flow<List<Buku>>
    suspend fun insertKategori(kategori: KategoriBuku)
    suspend fun insertBuku(buku: Buku)
    suspend fun deleteKategoriAman(idKategori: Int)
}

class OfflineRepositoriPerpus(
    private val bukuDao: BukuDao,
    private val kategoriDao: KategoriBukuDao
): RepositoriPerpus{
    override fun getAllKategori() = kategoriDao.getAllKategori()
    override fun getAllBuku() = bukuDao.getAllBuku()
    override suspend fun insertKategori(kategori: KategoriBuku) = kategoriDao.insert(kategori)
    override suspend fun insertBuku(buku: Buku) = bukuDao.insert(buku)
}