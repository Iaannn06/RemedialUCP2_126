package com.example.remeducp2.view.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class EntryViewModel(private val repositoriProduk: RepositoriProduk): ViewModel() {


    var uiStateProduk by mutableStateOf(UIStateProduk())
        private set

    private fun validasiInput(uiState: DetailProduk = uiStateProduk.detailProduk): Boolean {
        return with(uiState) {
            nama_produk.isNotBlank() && warna.isNotBlank() && ukuran.isNotBlank()
        }
    }

    fun updateUiState(detailProduk: DetailProduk) {
        uiStateProduk =
            UIStateProduk(detailProduk = detailProduk, isEntryValid = validasiInput(detailProduk))
    }

    suspend fun saveProduk() {
        if (validasiInput()) {
            RepositoriProduk.insertProduk(uiStateProduk.detailProduk.toProduk())
        }
    }
}


data class UIStateProduk(
    val detailProduk: DetailProduk = DetailProduk(),
    val isEntryValid: Boolean = false
)


data class DetailProduk(
    val bukuBaru: Int = 0,
    val nama_produk: String = "",
    val warna: String = "",
    val ukuran: String = ""
)


fun DetailProduk.toProduk(): Produk = Produk(
    id = id,
    nama_produk = nama_produk,
    warna = warna,
    ukuran = ukuran
)


fun Produk.toDetailProduk(): DetailProduk = DetailProduk(
    id = id,
    nama_produk = nama_produk,
    warna = warna,
    ukuran = ukuran
)


fun Produk.toUiStateProduk(isEntryValid: Boolean = false): UIStateProduk = UIStateProduk(
    detailProduk = this.toDetailProduk(),
    isEntryValid = isEntryValid
)