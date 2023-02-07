package com.gh.ghcomposedemo

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun AppScaffold(
) {
//    Text(text = "主页\n主页", modifier = Modifier.fillMaxSize())

    val navCtrl = rememberNavController()
    val navBackStackEntry by navCtrl.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        bottomBar = { BottomNavBarView(navCtrl = navCtrl) },
        content = {
            NavHost(
                modifier = Modifier.background(MaterialTheme.colors.background),
                navController = navCtrl,
                startDestination = RouteName.HOME
            ) {
                composable(route = RouteName.HOME) {
                    HomePage()
                }
                composable(route = RouteName.CATEGORY) {
                    Text(text = "购物车", modifier = Modifier.fillMaxSize())
                }
                composable(route = RouteName.COLLECTION) {
                    Text(text = "列表", modifier = Modifier.fillMaxSize())
                }
                composable(route = RouteName.PROFILE) {
                    Text(text = "我的", modifier = Modifier.fillMaxSize())
                }
            }
        }
    )

}

@Composable
fun BottomNavBarView(navCtrl: NavHostController) {
    val bottomNavList = listOf(
        BottomNavRoute.Home,
        BottomNavRoute.Category,
        BottomNavRoute.Collection,
        BottomNavRoute.Profile,
    )
    BottomNavigation {
        val navBackStackEntry by navCtrl.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        bottomNavList.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier,
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = screen.stringId))
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.routeName } == true,
                onClick = {
                    if (screen.routeName != currentDestination?.route) {
                        navCtrl.navigate(screen.routeName) {
                            // TODO:
                        }
                    }
                }
            )
        }
    }
}

sealed class BottomNavRoute(
    var routeName: String,
    @StringRes var stringId: Int,
    var icon: ImageVector,
) {
    object Home : BottomNavRoute(RouteName.HOME, R.string.home, Icons.Default.Home)
    object Category : BottomNavRoute(RouteName.CATEGORY, R.string.category, Icons.Default.Menu)
    object Collection :
        BottomNavRoute(RouteName.COLLECTION, R.string.collection, Icons.Default.Favorite)

    object Profile : BottomNavRoute(RouteName.PROFILE, R.string.profile, Icons.Default.Person)
}

object RouteName {
    const val HOME = "home"
    const val CATEGORY = "category"
    const val COLLECTION = "collection"
    const val PROFILE = "profile"
    const val WEB_VIEW = "web_view"
    const val LOGIN = "login"
    const val ARTICLE_SEARCH = "article_search"
}
