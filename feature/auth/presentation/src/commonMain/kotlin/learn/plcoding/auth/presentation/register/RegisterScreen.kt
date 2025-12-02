package learn.plcoding.auth.presentation.register

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.core.designsystem.components.layouts.MyChirpAdaptiveFormLayout
import learn.plcoding.core.designsystem.components.brand.MyChirpBrandLogo
import learn.plcoding.core.designsystem.components.buttons.MyChirpButton
import learn.plcoding.core.designsystem.components.buttons.MyChirpButtonStyle
import learn.plcoding.core.designsystem.components.layout.MyChirpSnackbarScaffold
import learn.plcoding.core.designsystem.components.textfields.MyChirpPasswordTextField
import learn.plcoding.core.designsystem.components.textfields.MyChirpTextField
import learn.plcoding.core.designsystem.theme.MyChirpTheme
import mychirp.feature.auth.presentation.generated.resources.Res
import mychirp.feature.auth.presentation.generated.resources.email
import mychirp.feature.auth.presentation.generated.resources.email_placeholder
import mychirp.feature.auth.presentation.generated.resources.login
import mychirp.feature.auth.presentation.generated.resources.password
import mychirp.feature.auth.presentation.generated.resources.password_hint
import mychirp.feature.auth.presentation.generated.resources.register
import mychirp.feature.auth.presentation.generated.resources.username
import mychirp.feature.auth.presentation.generated.resources.username_hint
import mychirp.feature.auth.presentation.generated.resources.username_placeholder
import mychirp.feature.auth.presentation.generated.resources.welcome_to_chirp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RegisterRoot(
    viewModel: RegisterViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    RegisterScreen(
        state = state,
        onAction = viewModel::onAction,
        snackbarHostState = snackbarHostState
    )
}

@Composable
fun RegisterScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit,
    snackbarHostState : SnackbarHostState
) {
    MyChirpSnackbarScaffold(
        snackbarHostState = snackbarHostState
    ) {
        MyChirpAdaptiveFormLayout(
            stringResource(Res.string.welcome_to_chirp),
            errorText = state.registrationError?.asString(),
            logo = { MyChirpBrandLogo() }
        ) {
            MyChirpTextField(
                state = state.usernameTextState,
                placeholder = stringResource(Res.string.username_placeholder),
                title = stringResource(Res.string.username),
                supportingText = state.usernameError?.asString()
                    ?: stringResource(Res.string.username_hint),
                isError = state.usernameError != null,
                onFocusChanged = { isFocused ->
                    onAction(RegisterAction.OnInputTextFocusGain)
                }
            )
            Spacer(Modifier.height(16.dp))
            MyChirpTextField(
                state = state.emailTextState,
                placeholder = stringResource(Res.string.email_placeholder),
                title = stringResource(Res.string.email),
                supportingText = state.emailError?.asString(),
                isError = state.emailError != null,
                onFocusChanged = { isFocused ->
                    onAction(RegisterAction.OnInputTextFocusGain)
                }
            )
            Spacer(Modifier.height(16.dp))
            MyChirpPasswordTextField(
                state = state.passwordTextState,
                placeholder = stringResource(Res.string.password),
                title = stringResource(Res.string.password),
                supportingText = state.passwordError?.asString()
                    ?: stringResource(Res.string.password_hint),
                isError = state.passwordError != null,
                onFocusChanged = { isFocused ->
                    onAction(RegisterAction.OnInputTextFocusGain)
                },
                isPasswordVisible = state.isPasswordVisible,
                onToggleVisibilityClick = {
                    onAction(RegisterAction.OnTogglePasswordVisibilityClick)
                }
            )
            Spacer(Modifier.height(16.dp))

            MyChirpButton(
                text = stringResource(Res.string.register),
                onClick = {
                    onAction(RegisterAction.OnRegisterClick)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                enabled = state.canRegister,
                isLoading = state.isRegistering,
            )
            Spacer(Modifier.height(8.dp))

            MyChirpButton(
                text = stringResource(Res.string.login),
                onClick = {
                    onAction(RegisterAction.OnLoginClick)
                },
                style = MyChirpButtonStyle.SECONDARY,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }
    }

}

@Preview
@Composable
private fun Preview() {
    MyChirpTheme {
        RegisterScreen(
            state = RegisterState(),
            onAction = {},
            snackbarHostState = remember { SnackbarHostState() }
        )
    }
}