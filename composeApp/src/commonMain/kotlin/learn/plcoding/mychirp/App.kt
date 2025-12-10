package learn.plcoding.mychirp


import androidx.compose.runtime.*
import learn.plcoding.auth.presentation.register.RegisterRoot
import learn.plcoding.core.designsystem.theme.MyChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MyChirpTheme {
        RegisterRoot(
            onRegisterSuccess = {  }
        )
    }
}