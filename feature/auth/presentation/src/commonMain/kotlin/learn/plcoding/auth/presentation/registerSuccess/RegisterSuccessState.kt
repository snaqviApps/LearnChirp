package learn.plcoding.auth.presentation.registerSuccess

data class RegisterSuccessState(
    val registeredEmail: String = "",
    val isResendingVerificationEmail: Boolean = false
)