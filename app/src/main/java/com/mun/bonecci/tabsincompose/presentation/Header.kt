package com.mun.bonecci.tabsincompose.presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mun.bonecci.tabsincompose.Constants
import com.mun.bonecci.tabsincompose.components.TabsCustomComponent
import com.mun.bonecci.tabsincompose.ui.theme.TabsInComposeTheme

/**
 * A header component displaying custom tabs.
 *
 * @param tabs List of tab titles.
 * @param onTabSelected Callback function invoked when a tab is selected.
 */
@Composable
fun Header(tabs: List<String>, onTabSelected: (String) -> Unit) {
    // Box composable to arrange content
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        // Custom tabs component
        TabsCustomComponent(tabs, Modifier.align(Alignment.Center), onSelected = { optionSelected ->
            // Invoke the callback when a tab is selected
            onTabSelected.invoke(optionSelected)
        })
    }
}

@Preview(name = Constants.LIGHT_MODE)
@Preview(name = Constants.DARK_MODE, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ShowHeaderPreview() {
    val tabs = listOf(
        "Tab 1",
        "Tab 2",
        "Tab 3",
    )

    TabsInComposeTheme {
        Surface {
            Header(tabs = tabs, onTabSelected = {})
        }
    }
}