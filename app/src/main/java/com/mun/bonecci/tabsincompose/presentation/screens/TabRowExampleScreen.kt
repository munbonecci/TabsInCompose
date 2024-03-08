package com.mun.bonecci.tabsincompose.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mun.bonecci.tabsincompose.components.TabRowComponent

/**
 * A screen demonstrating the usage of the TabRowComponent to create a tabbed interface.
 */
@Composable
fun TabRowExampleScreen() {
    // List of tab titles
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    // Display the TabRowComponent with specified tabs and content screens
    TabRowComponent(
        tabs = tabs,
        contentScreens = listOf(
            { FollowingTabScreen() },  // Content screen for Tab 1
            { ForYouTabScreen() },      // Content screen for Tab 2
            { SubscribedTabScreen() }   // Content screen for Tab 3
        ),
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Gray,
        contentColor = Color.White,
        indicatorColor = Color.DarkGray
    )
}