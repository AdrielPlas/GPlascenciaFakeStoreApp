package com.example.fakestoreapp

import android.R
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.fakestoreapp.screens.HomeScreen
import com.example.fakestoreapp.screens.ProductDetailScreen
import com.example.fakestoreapp.ui.theme.BackgroundProductCard
import com.example.fakestoreapp.ui.theme.FakeStoreAppTheme
import com.example.fakestoreapp.ui.theme.FontDetailColor
import com.example.fakestoreapp.ui.theme.HomeScreenRoute
import com.example.fakestoreapp.ui.theme.ProductDetailScreenRoute

/*
    CREAR MODELOS
    CREAR SERVICIOS
    CONSUMIR SERVICIOS
    REFRESCAR UI
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FakeStoreAppTheme {
                val navController = rememberNavController()
                var showBottomBar by remember { mutableStateOf(true) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (showBottomBar){
                            // Barra de navegacion inferior
                            NavigationBar(
                                modifier = Modifier
                                    .background(Color.White)
                                    .border(
                                        width = 2.dp,
                                        color = Color.LightGray,
                                        shape = RectangleShape
                                    ),
                            ) {
                                NavigationBarItem(
                                    selected = true,
                                    onClick ={
                                        showBottomBar = true
                                        navController.navigate(HomeScreenRoute){
                                            launchSingleTop = true
                                            //Grafo Splash Screen
                                            popUpTo(navController.graph.startDestinationId){
                                                saveState = true
                                            }
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.Home,
                                            contentDescription = "home",
                                            modifier = Modifier.size(35.dp),
                                            tint = Color.White
                                        )
                                    },
                                )
                                NavigationBarItem(
                                    selected = false,
                                    onClick ={
                                        navController.navigate(ProductDetailScreenRoute){
                                            launchSingleTop = true
                                            //Grafo Splash Screen
                                            popUpTo(navController.graph.startDestinationId){
                                                saveState = true
                                            }
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.ShoppingCart,
                                            contentDescription = "list cart",
                                            modifier = Modifier.size(35.dp),
                                            tint = Color.DarkGray
                                        )
                                    },
                                )
                                NavigationBarItem(
                                    selected = false,
                                    onClick ={
                                        navController.navigate(ProductDetailScreenRoute){
                                            launchSingleTop = true
                                            //Grafo Splash Screen
                                            popUpTo(navController.graph.startDestinationId){
                                                saveState = true
                                            }
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.AccountCircle,
                                            contentDescription = "profile",
                                            modifier = Modifier.size(35.dp),
                                             tint = Color.DarkGray
                                        )
                                    },
                                )
                            }
                        }

                }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreenRoute
                    ) {
                        composable<HomeScreenRoute>{
                            HomeScreen(
                                 navController
                            )
                            showBottomBar = true
                        }
                        composable<ProductDetailScreenRoute> { backStack ->
                            val args = backStack.toRoute<ProductDetailScreenRoute>()
                            showBottomBar = false
                            ProductDetailScreen(args.id, navController)
                        }
                    }
                }
            }
        }
    }
}
