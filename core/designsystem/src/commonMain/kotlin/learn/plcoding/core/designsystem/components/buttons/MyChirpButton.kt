package learn.plcoding.core.designsystem.components.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import learn.plcoding.core.designsystem.theme.extended
import learn.plcoding.core.designsystem.theme.MyChirpTheme

import org.jetbrains.compose.ui.tooling.preview.Preview

enum class MyChirpButtonStyle {
    PRIMARY,
    DESTRUCTIVE_PRIMARY,
    SECONDARY,
    DESTRUCTIVE_SECONDARY,
    TEXT
}

@Composable
fun MyChirpButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: MyChirpButtonStyle = MyChirpButtonStyle.PRIMARY,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null

    //    buttonColors: ButtonColors
) {
    val colors = when (style) {
        MyChirpButtonStyle.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.extended.disabledFill,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )

        MyChirpButtonStyle.DESTRUCTIVE_PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError,
            disabledContainerColor = MaterialTheme.colorScheme.extended.disabledFill,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )

        MyChirpButtonStyle.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.extended.textSecondary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )

        MyChirpButtonStyle.DESTRUCTIVE_SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.error,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )

        MyChirpButtonStyle.TEXT -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.tertiary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )
    }

    val defaultBorderStroke: BorderStroke = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.extended.disabledOutline
    )
    val border = when {
        style == MyChirpButtonStyle.PRIMARY && !enabled -> defaultBorderStroke
        style == MyChirpButtonStyle.SECONDARY && !enabled -> defaultBorderStroke
        style == MyChirpButtonStyle.DESTRUCTIVE_PRIMARY && !enabled -> defaultBorderStroke
        style == MyChirpButtonStyle.DESTRUCTIVE_SECONDARY && !enabled -> {
            val borderColor = if(enabled) {
                MaterialTheme.colorScheme.extended.destructiveSecondaryOutline
            } else {
                MaterialTheme.colorScheme.extended.disabledOutline
            }
            BorderStroke (
                width = 1.dp,
                color = borderColor
            )
        }
        else -> null
    }

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        colors = colors,
        border = border
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(15.dp)
                    .alpha(
                        if (isLoading) 1f else 0f
                    ),
                strokeWidth = 1.5.dp,
                color = Color.Blue

            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                leadingIcon?.invoke()
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}

@Composable
@Preview
fun MyChirpPrimaryButtonPreview() {
    MyChirpTheme {
        MyChirpButton(
            text = "Primary Button",
            onClick = {},
            style = MyChirpButtonStyle.PRIMARY
        )
    }
}

@Composable
@Preview
fun MyChirpDestructivePrimaryButtonPreview() {
    MyChirpTheme {
        MyChirpButton(
            text = "Destructive Primary Button",
            onClick = {},
            style = MyChirpButtonStyle.DESTRUCTIVE_PRIMARY
        )
    }
}

@Composable
@Preview
fun MyChirpSecondaryButtonPreview() {
    MyChirpTheme {
        MyChirpButton(
            text = "Secondary Button",
            onClick = {},
            style = MyChirpButtonStyle.SECONDARY
        )
    }
}

@Composable
@Preview
fun MyChirpDestructiveSecondaryButtonPreview() {
    MyChirpTheme {
        MyChirpButton(
            text = "Destructive Secondary Button",
            onClick = {},
            style = MyChirpButtonStyle.DESTRUCTIVE_SECONDARY
        )
    }
}

@Composable
@Preview
fun MyChirpTextButtonPreview() {
    MyChirpTheme(
        darkTheme = false
    ) {
        MyChirpButton(
            text = "Text Button",
            onClick = {},
            style = MyChirpButtonStyle.TEXT
        )
    }
}
