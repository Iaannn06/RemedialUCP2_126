package com.example.remeducp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblBuku")
data class Buku(
    @PrimaryKey(autoGenerate = true)
    val idBuku: Int = 1,
    val judulBuku: String,
    val penulis: String,
    val idKategoriBuku: Int?,
    val statusPinjam: Boolean = false,
    val isDeleted: Boolean = false
)
