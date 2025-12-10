package learn.plcoding.auth.presentation.register

import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import learn.plcoding.auth.domain.EmailValidator
import learn.plcoding.core.domain.auth.AuthService
import learn.plcoding.core.domain.util.onFailure
import learn.plcoding.core.domain.util.onSuccess
import learn.plcoding.core.domain.validation.PasswordValidator
import learn.plcoding.core.presentation.util.UiText
import learn.plcoding.core.presentation.util.toUiText
import mychirp.feature.auth.presentation.generated.resources.Res
import mychirp.feature.auth.presentation.generated.resources.error_invalid_email
import mychirp.feature.auth.presentation.generated.resources.error_invalid_password
import mychirp.feature.auth.presentation.generated.resources.error_invalid_username

class RegisterViewModel(
    private val authService: AuthService
) : ViewModel() {

    private var hasLoadedInitialData = false

    private val eventChannel = Channel<RegisterEvent>()    // receives 'Event' as 'flow' from some processing/logic, and sent to 'UI', that 'observes it as an 'Event'
    val events = eventChannel.receiveAsFlow()

    private val _state = MutableStateFlow(RegisterState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                observeValidationStates()
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = RegisterState()
        )

    private val isEmailValidFlow = snapshotFlow { state.value.emailTextState.text.toString() }
        .map { email -> EmailValidator.validate(email) }
        .distinctUntilChanged()
    private val isUsernameValidFlow = snapshotFlow { state.value.usernameTextState.text.toString() }
        .map { username -> username.length in 3..20 }
        .distinctUntilChanged()
    private val isPasswordValidFlow = snapshotFlow { state.value.passwordTextState.text.toString() }
        .map { password -> PasswordValidator.validate(password).isValidPassword }
        .distinctUntilChanged()

    private fun observeValidationStates() {
        combine(
            isEmailValidFlow,
            isUsernameValidFlow,
            isPasswordValidFlow
        ) { isEmailValid, isUsernameValid, isPasswordValid ->
            val allValid = isEmailValid && isUsernameValid && isPasswordValid
            _state.update {
                it.copy(
                    canRegister = !it.isRegistering && allValid
                ) }
        }.launchIn(viewModelScope)
    }


    fun onAction(action: RegisterAction) {
        when (action) {
            RegisterAction.OnLoginClick -> validateFormInputs()
            RegisterAction.OnRegisterClick -> register()
            RegisterAction.OnTogglePasswordVisibilityClick -> {
                _state.update {
                    it.copy(isPasswordVisible = !it.isPasswordVisible)
                }
            }
//            else ->  {  }     works too
            else -> Unit
        }
    }

    private fun register() {
        if (validateFormInputs()) return

        viewModelScope.launch {
            _state.update {
                it.copy(isRegistering = true)
            }
            val currentState = state.value.emailTextState.text.toString()
            val username = state.value.usernameTextState.text.toString()
            val password = state.value.passwordTextState.text.toString()
            authService.register(
                email = currentState,
                username = username,
                password = password
            )
                .onSuccess {
                    _state.update {
                        it.copy(isRegistering = false)
                    }

                }
                .onFailure { error ->
                    _state.update {
                        it.copy(
                            isRegistering = false,
                            registrationError = error.toUiText()
                        )
                    }
                }

        }

    }

    private fun clearAllTextFieldErrors() {
        _state.update {
            it.copy(
                emailError = null,
                usernameError = null,
                passwordError = null
            )
        }
    }

    fun validateFormInputs(): Boolean {
        clearAllTextFieldErrors()

        val currentState = state.value
        val email = currentState.emailTextState.text.toString()
        val username = currentState.usernameTextState.text.toString()
        val password = currentState.passwordTextState.text.toString()

        val isEmailValid = EmailValidator.validate(email)
        val passwordValidationState = PasswordValidator.validate(password)
        val isUsernameValid = username.length in 3..20

        val emailError = if (!isEmailValid) {
            UiText.Resource(Res.string.error_invalid_email)
        } else null
        val usernameError = if (!isUsernameValid) {
            UiText.Resource(Res.string.error_invalid_username)
        } else null
        val passwordError = if (!passwordValidationState.isValidPassword) {
            UiText.Resource(Res.string.error_invalid_password)
        } else null

        _state.update {
            it.copy(
                emailError = emailError,
                usernameError = usernameError,
                passwordError = passwordError
            )
        }

        return isUsernameValid && isEmailValid && passwordValidationState.isValidPassword
    }
}


