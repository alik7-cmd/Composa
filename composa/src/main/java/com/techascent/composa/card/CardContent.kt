package com.techascent.composa.card

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A customizable card-like container with optional background color and border styling.
 *
 * `ComposaCardFrame` wraps a [Card] with a consistent rounded shape and allows applying
 * a border and an optional background (container) color.
 *
 * @param modifier The [Modifier] to be applied to the card.
 * @param content The composable content to be placed inside the card.
 * @param borderColor The color of the border around the card.
 * @param containerColor Optional background color for the card. If null, the default
 *                       card background color is used.
 */
@Composable
fun ComposaCardFrame(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    borderColor: Color,
    containerColor: Color?
) {
    val shape = RoundedCornerShape(8.dp)
    val cardColors = containerColor?.let {
        CardDefaults.cardColors(
            containerColor = it
        )
    } ?: CardDefaults.cardColors()
    Card(
        modifier = modifier
            .border(
                width = 0.5.dp,
                color = borderColor,
                shape = shape,
            )
            .clip(shape),
        shape = shape,
        colors = cardColors
    ) {
        Column {
            content()
        }
    }
}

