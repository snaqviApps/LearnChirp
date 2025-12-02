package learn.plcoding.core.domain.validation

object PasswordValidator  {
    private const val MIN_PASSWORD_LENGTH = 9
    fun validate(password: String): PasswordValidationState {
        return PasswordValidationState(
            hasMinLength = password.length >= MIN_PASSWORD_LENGTH,
            hasUppercase = password.any { it.isUpperCase() },
            hasDigit = password.any { it.isDigit() }
            )
    }

}