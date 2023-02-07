package com.gh.ghcomposedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.gh.ghcomposedemo.ui.theme.AppShapes
import com.gh.ghcomposedemo.ui.theme.AppTheme

@Composable
fun SquarePage(

) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(listOf("111", "111", "111", "111", "111", "111", "111")) {
//            Text(text = it)
            MultiStateItemView(data = it)
        }
    }

}

@Composable
fun MultiStateItemView(
    modifier: Modifier = Modifier,
    data: String,
    isTop: Boolean = false,
    onSelected: (data: String) -> Unit = {},
    onClooectClick: (articleId: Int) -> Unit = {},
    onUserClick: (userId: Int) -> Unit = {},
    isLoading: Boolean = false
) {
    Card(
        modifier = modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .background(color = AppTheme.colors.card)
            .fillMaxWidth()
            .clickable(enabled = !isLoading) {
                onSelected.invoke(data)
            },
        shape = AppShapes.medium,
        backgroundColor = AppTheme.colors.listItem,
    ) {
//        Text(text = "列表item", modifier = Modifier.padding(20.dp))
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {



        }
    }
}


