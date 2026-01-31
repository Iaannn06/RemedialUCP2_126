package com.example.remeducp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tblKategoriBuku")
data class KategoriBuku(
    @PrimaryKey(autoGenerate = true)
    val idKategori: Int = 0,
    val nama: String,
    val deskripsi: String,
    val tanggalMasuk: Date,
    val isDeleted: Boolean = false
    )
