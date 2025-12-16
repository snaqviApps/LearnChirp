package learn.plcoding.auth.presentation.registerSuccess

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import learn.plcoding.core.designsystem.components.brand.MyChirpSuccessIcon
import learn.plcoding.core.designsystem.components.buttons.MyChirpButton
import learn.plcoding.core.designsystem.components.buttons.MyChirpButtonStyle
import learn.plcoding.core.designsystem.components.layout.MyChirpAdaptiveResultLayout
import learn.plcoding.core.designsystem.components.layout.MyChirpSimpleSuccessLayout
import learn.plcoding.core.designsystem.theme.MyChirpTheme
import mychirp.feature.auth.presentation.generated.resources.Res
import mychirp.feature.auth.presentation.generated.resources.account_successfully_created
import mychirp.feature.auth.presentation.generated.resources.login
import mychirp.feature.auth.presentation.generated.resources.resend_verification_email
import mychirp.feature.auth.presentation.generated.resources.verification_email_sent_to_x
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegisterSuccessRoot(
    viewModel: RegisterSuccessViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    RegisterSuccessScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun RegisterSuccessScreen(
    state: RegisterSuccessState,
    onAction: (RegisterSuccessAction) -> Unit,
) {
    MyChirpAdaptiveResultLayout {
        MyChirpSimpleSuccessLayout(
            title = stringResource(Res.string.account_successfully_created),
            description = stringResource(
                Res.string.verification_email_sent_to_x,
                state.registeredEmail
            ),
            icon = {
                MyChirpSuccessIcon()
            },
            primaryButton = {
                MyChirpButton(
                    text = stringResource(Res.string.login),
                    onClick = {
                        onAction(RegisterSuccessAction.OnLoginClick)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            },
            secondaryButton = {
                MyChirpButton(
                    text = stringResource(Res.string.resend_verification_email),
                    onClick = {
                        onAction(RegisterSuccessAction.OnResendVerificationEmailClick)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = !state.isResendingVerificationEmail,
                    isLoading = state.isResendingVerificationEmail,
                    style = MyChirpButtonStyle.SECONDARY
                )
            }
        )
    }
}


@Preview
@Composable
private fun Preview() {
    MyChirpTheme {
        RegisterSuccessScreen(
            state = RegisterSuccessState(),
            onAction = {}
        )
    }
}