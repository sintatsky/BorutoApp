package com.example.borutoapp.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.borutoapp.presentation.components.RatingWidget
import com.example.borutoapp.ui.theme.LARGE_PADDING
import com.example.borutoapp.ui.theme.SMALL_PADDING

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = { })
        }
    ) {
        RatingWidget(modifier = Modifier.padding(all = SMALL_PADDING),rating = 2.5)
    }
}