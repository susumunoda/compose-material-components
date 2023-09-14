package com.susumunoda.compose.material3

import androidx.annotation.StringRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class TabOption(@StringRes val titleId: Int)

enum class TabType { PRIMARY, SECONDARY }

@Composable
fun Tabs(
    tabType: TabType,
    tabOptions: List<TabOption>,
    selectedTabIndex: Int,
    onSelectTabIndex: (Int) -> Unit,
    modifier: Modifier = Modifier,
    tabPadding: Dp = 16.dp
) {
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        if (selectedTabIndex < tabPositions.size) {
            when (tabType) {
                TabType.PRIMARY -> {
                    val width by animateDpAsState(
                        label = "tab animation",
                        targetValue = tabPositions[selectedTabIndex].contentWidth
                    )
                    TabRowDefaults.PrimaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        width = width
                    )
                }

                TabType.SECONDARY -> {
                    TabRowDefaults.SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                    )
                }
            }
        }
    }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        indicator = indicator,
        modifier = modifier
    ) {
        tabOptions.forEachIndexed { index, tabOption ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onSelectTabIndex(index) },
                modifier = Modifier.padding(tabPadding)
            ) {
                Text(
                    stringResource(tabOption.titleId),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}