package com.example.remeducp2.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.view.ProdukTopAppBar
import com.example.ucp2.view.route.DestinasiDetailProduk
import com.example.ucp2.viewmodel.DetailViewModel
import com.example.ucp2.viewmodel.provider.PenyediaViewModel
import com.teoriweek9.teoriweek9.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailProdukScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    Scaffold(
        topBar = {
            ProdukTopAppBar(
                title = stringResource(DestinasiDetailProduk.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },
        floatingActionButton = {
            val uiState = viewModel.uiDetailState.collectAsState()
            FloatingActionButton(
                onClick = {
                    navigateToEditItem(uiState.value.DetailProduk.id) // Diaktifkan
                },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))

            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(R.string.update),
                )
            }
        }, modifier = modifier
    ) { innerPadding ->
        val uiState = viewModel.uiDetailState.collectAsState()
        val coroutineScope = rememberCoroutineScope()
        BodyDetailDataProduk(
            detailSiswaUiState = uiState.value,
            onDelete = { coroutineScope.launch {
                viewModel.deleteProduk()
                navigateBack()
            }},
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        )
    }
}