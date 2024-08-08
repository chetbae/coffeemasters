package com.frontendmasters.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.frontendmasters.coffeemasters.pages.InfoPage
import com.frontendmasters.coffeemasters.pages.MenuPage
import com.frontendmasters.coffeemasters.pages.OffersPage
import com.frontendmasters.coffeemasters.pages.OrderPage
import com.frontendmasters.coffeemasters.ui.theme.CoffeeMastersTheme

//@Preview
//@Composable
//fun App_Preview() {
//    CoffeeMastersTheme {
//        App()
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataManager: DataManager) {
    val selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { AppTitle() },
                colors = TopAppBarColors(
                    actionIconContentColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                when (selectedRoute.value) {
                    Routes.OffersPage.route -> OffersPage()
                    Routes.MenuPage.route -> MenuPage(dataManager)
                    Routes.InfoPage.route -> InfoPage()
                    Routes.OrderPage.route -> OrderPage(dataManager)
                }
            }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = { newRoute ->
                selectedRoute.value = newRoute
            })
        },
    )
}

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo",
            modifier = Modifier.size(150.dp)
        )
    }
}