package learn.plcoding.core.designsystem.components.textfields

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import learn.plcoding.core.designsystem.theme.MyChirpTheme
import learn.plcoding.core.designsystem.theme.extended
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MyChirpTextField(
    modifier: Modifier = Modifier,
    /**
     * 'Compose-state', that is different than default Material-Design 'textField'
     * that does not have 'reactive' support for its own flow-related
     * limitations, like it could react to a wrongly entered phrase
     * instead of correct e.g: email
     * */
    state: TextFieldState,

    placeholder: String? = null,
    title: String? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    singleLine: Boolean = false,
    enabled: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    onFocusChanged: (Boolean) -> Unit = {},
) {

    MyChirpTextFieldLayout(
        title = title,
        isError = isError,
        placeholder = placeholder,
        supportingText = supportingText,
        enabled = enabled,
        onFocusChanged = onFocusChanged,
        modifier = modifier,
    ) { sharedTextFieldStyleModifier, sharedInteractionSource ->

        /** This is dynamic text field **/
        BasicTextField(
            state = state,
            enabled = enabled,
            lineLimits = if (singleLine) {
                TextFieldLineLimits.SingleLine
            } else TextFieldLineLimits.Default,
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                color = if (enabled) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.extended.textPlaceholder
                }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface),
//            interactionSource = interactionSource,
            interactionSource = sharedInteractionSource,
            modifier = sharedTextFieldStyleModifier,
            decorator = { innerBox ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (state.text.isEmpty() && placeholder != null) {
                        Text(
                            text = placeholder,
                            color = MaterialTheme.colorScheme.extended.textPlaceholder,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    innerBox()
                }
            }
        )
    }
}

@Composable
@Preview(
    showBackground = true
)
fun MyChirpTextFieldEmptyPreview() {
    MyChirpTheme {
        MyChirpTextField(
            modifier = Modifier
                .width(300.dp),
            state = rememberTextFieldState(),
            placeholder = "test@test.com",
            title = "Email",
            supportingText = "Please enter your email",
        )
    }
}

@Composable
@Preview(
    showBackground = true
)
fun MyChirpTextFieldFilledPreview() {
    MyChirpTheme {
        MyChirpTextField(
            modifier = Modifier
                .width(300.dp),
            state = rememberTextFieldState(
                initialText = "test@test.com"
            ),
            placeholder = "test@test.com",
            title = "Email",
            supportingText = "Please enter your email",
        )
    }
}

@Composable
@Preview(
    showBackground = true
)
fun MyChirpTextFieldDisabledPreview() {
    MyChirpTheme {
        MyChirpTextField(
            state = rememberTextFieldState(),
            modifier = Modifier
                .width(300.dp),
            placeholder = "test@test.com",
            title = "Email",
            supportingText = "Please enter your email",
            enabled = false
        )
    }
}

@Composable
@Preview(
    showBackground = true
)
fun MyChirpTextFieldErrorPreview() {
    MyChirpTheme {
        MyChirpTextField(
            modifier = Modifier
                .width(300.dp),
            state = rememberTextFieldState(),
            placeholder = "test@test.com",
            title = "Email",
            supportingText = "This is not a valid email",
            isError = true,
        )
    }
}