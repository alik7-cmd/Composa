package com.techascent.composa.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techascent.composa.theming.ComposaColors

/**
 * Represents the properties of an avatar, including size, badge size, font size, font color, and background color.
 *
 * @property size The size of the avatar.
 * @property badgeSize The size of the badge displayed on the avatar.
 * @property fontSize The font size of the text inside the avatar.
 * @property fontColor The color of the text inside the avatar. Defaults to [ComposaColors.GREEN_100].
 * @property backgroundColor The background color of the avatar. Defaults to [ComposaColors.GREEN_300].
 */
@Immutable
data class AvatarProperties internal constructor(
    val size: Dp,
    val badgeSize: Dp,
    val fontSize: TextUnit,
    val fontColor: Color = ComposaColors.GREEN_100,
    val backgroundColor: Color = ComposaColors.GREEN_300
)

/**
 * Provides default configurations for avatar properties.
 *
 * Includes predefined sizes (small, medium, large) and a customizable option.
 */
object AvatarDefaults {

    val small: AvatarProperties
        @Composable
        get() = AvatarProperties(
            size = 24.dp,
            badgeSize = 8.dp,
            fontSize = 15.sp
        )

    val medium: AvatarProperties
        @Composable
        get() = AvatarProperties(
            size = 32.dp,
            badgeSize = 12.dp,
            fontSize = 17.sp,
        )

    val large: AvatarProperties
        @Composable
        get() = AvatarProperties(
            size = 64.dp,
            badgeSize = 24.dp,
            fontSize = 34.sp,
        )
    val custom: (Dp, Dp, TextUnit, Color, Color) -> AvatarProperties
        @Composable
        get() = { size, badgeSize, fontSize, fontColor, backgroundColor ->
            AvatarProperties(
                size = size,
                badgeSize = badgeSize,
                fontSize = fontSize,
                fontColor = fontColor,
                backgroundColor = backgroundColor
            )
        }
}

/**
 * A composable function to display an avatar with customizable properties.
 *
 * @param initial The initial character to display inside the avatar.
 * @param avatarProperties The properties of the avatar, such as size, font, and colors.
 * @param modifier The [Modifier] to be applied to the avatar.
 * @param content Optional content to display inside the avatar, such as a badge.
 */
@Composable
fun Avatar(
    initial: Char,
    avatarProperties: AvatarProperties,
    modifier: Modifier = Modifier,
    content: (@Composable BoxScope.() -> Unit)? = null,
) {
    val density = LocalDensity.current
    val fontScale = density.fontScale
    Box(
        modifier = modifier
            .size(avatarProperties.size * fontScale)
            .background(
                color = avatarProperties.backgroundColor,
                shape = CircleShape
            ),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = initial.toString(),
            fontSize = avatarProperties.fontSize,
            fontWeight = FontWeight.Bold,
            color = avatarProperties.fontColor
        )

        content?.let {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(avatarProperties.badgeSize * fontScale),
                content = it
            )
        }
    }
}

@Preview
@Composable
fun AvatarPreview() {
    Avatar(
        initial = 'A',
        avatarProperties = AvatarDefaults.small
    )
}