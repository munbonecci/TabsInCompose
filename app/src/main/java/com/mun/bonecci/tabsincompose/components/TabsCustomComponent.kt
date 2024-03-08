package com.mun.bonecci.tabsincompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.mun.bonecci.tabsincompose.ui.theme.dimen_12dp
import com.mun.bonecci.tabsincompose.ui.theme.dimen_16dp
import com.mun.bonecci.tabsincompose.ui.theme.dimen_24dp
import com.mun.bonecci.tabsincompose.ui.theme.dimen_2dp
import com.mun.bonecci.tabsincompose.ui.theme.dimen_4dp

/**
 * A custom Composable for displaying tabs.
 *
 * @param tabs List of tab titles.
 * @param modifier Modifier for the parent layout.
 * @param textColor Color for tab text.
 * @param selectedFontSize Font size for selected tab text.
 * @param unSelectedFontSize Font size for unselected tab text.
 * @param selectedColor Background color for selected tab.
 * @param unselectedColor Background color for unselected tab.
 * @param cornerRadius Corner radius for the tab background.
 * @param elevation Elevation for the tab background.
 * @param componentPadding Padding for the entire component.
 * @param textPaddingVertical Vertical padding for tab text.
 * @param textPaddingHorizontal Horizontal padding for tab text.
 * @param onSelected Callback function invoked when a tab is selected.
 */
@Composable
fun TabsCustomComponent(
    tabs: List<String>,
    modifier: Modifier,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    selectedFontSize: TextUnit = 12.sp,
    unSelectedFontSize: TextUnit = 10.sp,
    selectedColor: Color = Color.Transparent,
    unselectedColor: Color = Color.Transparent,
    cornerRadius: Dp = dimen_24dp,
    elevation: Dp = dimen_4dp,
    componentPadding: Dp = dimen_2dp,
    textPaddingVertical: Dp = dimen_12dp,
    textPaddingHorizontal: Dp = dimen_16dp,
    onSelected: (String) -> Unit
) {
    // State to keep track of the selected tab
    var selectedOption by remember { mutableStateOf(tabs[0]) }

    // Surface composable to create a background for tabs
    Surface(
        shape = RoundedCornerShape(cornerRadius),
        shadowElevation = elevation,
        modifier = modifier
            .wrapContentSize()
            .padding(componentPadding),
        color = unselectedColor
    ) {
        // Row to display the tabs horizontally
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(cornerRadius))
                .background(unselectedColor)
        ) {
            // Iterate over each tab
            tabs.forEach { text ->
                // Determine font weight and size based on the selected state
                val fontWeight = if (text == selectedOption) FontWeight.Bold else FontWeight.Normal
                val fontSize = if (text == selectedOption) selectedFontSize else unSelectedFontSize

                // Text composable representing each tab
                Text(
                    text = text,
                    color = textColor,
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(cornerRadius))
                        .clickable {
                            // Update the selected tab and invoke the callback
                            selectedOption = text
                            onSelected.invoke(text)
                        }
                        .background(
                            if (text == selectedOption) selectedColor else unselectedColor
                        )
                        .padding(
                            vertical = textPaddingVertical,
                            horizontal = textPaddingHorizontal,
                        ),
                )
            }
        }
    }
}