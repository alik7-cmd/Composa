package com.techascent.composa.divider

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A customizable horizontal divider used to separate UI elements in a layout.
 *
 * This composable wraps [HorizontalDivider] and applies a full-width layout by default.
 *
 * @param modifier The [Modifier] to be applied to the divider. Defaults to [Modifier].
 * @param thickness The thickness of the divider line. Defaults to 1.dp.
 * @param color The color of the divider line.
 */
@Composable
fun ComposaDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color?
) {
    val contentColor = color ?: DividerDefaults.color
    Divider(
        modifier = modifier
            .fillMaxWidth(),
        thickness = thickness,
        color = contentColor
    )
}