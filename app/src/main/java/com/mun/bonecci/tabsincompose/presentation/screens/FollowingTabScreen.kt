package com.mun.bonecci.tabsincompose.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mun.bonecci.tabsincompose.R
import com.mun.bonecci.tabsincompose.ui.theme.dimen_84dp

@Composable
fun FollowingTabScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val following = stringResource(id = R.string.following_label)
        Text(text = following, modifier = Modifier.padding(all = dimen_84dp))
    }
}