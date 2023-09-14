package com.susumunoda.compose.material3

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicator(
    showIndicator: Boolean,
    modifier: Modifier = Modifier,
    indicatorHeight: Dp = 4.dp
) {
    if (showIndicator) {
        LinearProgressIndicator(modifier.height(indicatorHeight))
    } else {
        Spacer(modifier.height(indicatorHeight))
    }
}