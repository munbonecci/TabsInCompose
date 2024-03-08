package com.mun.bonecci.tabsincompose.presentation.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mun.bonecci.tabsincompose.Constants
import com.mun.bonecci.tabsincompose.R
import com.mun.bonecci.tabsincompose.presentation.Header
import com.mun.bonecci.tabsincompose.ui.theme.TabsInComposeTheme

/**
 * A screen demonstrating the usage of custom tabs.
 *
 * @param modifier Modifier for the parent layout.
 */
@Composable
fun TabsCustomExampleScreen(modifier: Modifier = Modifier) {
    // Load tab titles from resources
    val following = stringResource(id = R.string.following_label)
    val forYou = stringResource(id = R.string.for_you_label)
    val subscribed = stringResource(id = R.string.subscribed_label)

    // Create a list of tab titles
    val tabs = listOf(following, forYou, subscribed)

    // State to keep track of the selected tab
    var tabSelected by remember { mutableStateOf(tabs[1]) }

    // Box composable to arrange content in a stack
    Box(
        modifier = modifier.layoutId("box_id"),
        contentAlignment = Alignment.TopCenter
    ) {
        // Display the content corresponding to the selected tab
        when (tabSelected) {
            following -> {
                FollowingTabScreen()
            }

            forYou -> {
                ForYouTabScreen()
            }

            subscribed -> {
                SubscribedTabScreen()
            }
        }

        // Header composable to display custom tabs
        Header(tabs, onTabSelected = { optionSelected ->
            // Update the selected tab when a tab is clicked
            tabSelected = optionSelected
        })
    }
}

@Preview(name = Constants.LIGHT_MODE)
@Preview(name = Constants.DARK_MODE, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ShowTabsCustomExampleScreen() {
    TabsInComposeTheme {
        Surface {
            TabsCustomExampleScreen()
        }
    }
}