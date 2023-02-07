package com.gh.ghcomposedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gh.ghcomposedemo.ui.theme.AppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun HomePage() {

    val scopeState = rememberCoroutineScope()

    Column {
        val titles = listOf(
            TabTitle(101, "广场"),
            TabTitle(102, "推荐"),
            TabTitle(103, "问答")
        )
        val pagerState = rememberPagerState(
            initialPage = 0
        )
        TextTabBar(
            index = pagerState.currentPage,
            tabTexts = titles,
            onTabSelected = { index ->
                scopeState.launch {
                    pagerState.scrollToPage(index)
                }
            }
        )
        HorizontalPager(
            count = titles.size,
            state = pagerState,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)
        ) { page ->
            when (page) {
                0 -> SquarePage()
                1 -> Text(text = "11111", modifier = Modifier.fillMaxSize())
                2 -> Text(text = "222222", modifier = Modifier.fillMaxSize())

            }
        }
    }

}

@Composable
fun TextTabBar(
    index: Int,
    tabTexts: List<TabTitle>,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    bgColor: Color = AppTheme.colors.themeUi,
    contentColor: Color = Color.White,
    onTabSelected: ((index: Int) -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .background(bgColor)
            .horizontalScroll(state = rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .align(contentAlignment)
        ) {
            tabTexts.forEachIndexed { i, tabTitle ->
                Text(
                    text = tabTitle.text,
                    fontSize = if (index == i) 20.sp else 15.sp,
                    fontWeight = if (index == i) FontWeight.Bold else FontWeight.Normal,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 10.dp)
                        .clickable { onTabSelected?.invoke(i) },
                    color = contentColor,
                )
            }
        }
    }
}

data class TabTitle(
    val id: Int,
    val text: String,
    var cachePosition: Int = 0,
    var selected: Boolean = false
)