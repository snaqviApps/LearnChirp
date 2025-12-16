package learn.plcoding.mychirp


import androidx.compose.runtime.*
import learn.plcoding.core.designsystem.theme.MyChirpTheme
import learn.plcoding.mychirp.navigation.NavigationRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MyChirpTheme {
        NavigationRoot()
    }
}