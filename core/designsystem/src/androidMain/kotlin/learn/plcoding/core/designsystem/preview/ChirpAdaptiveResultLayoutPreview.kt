package learn.plcoding.core.designsystem.preview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import learn.plcoding.core.designsystem.components.layout.MyChirpAdaptiveResultLayout
import learn.plcoding.core.designsystem.theme.MyChirpTheme

@Preview
@Composable
@PreviewLightDark
@PreviewScreenSizes
fun MyChirpAdaptiveResultLayoutPreview() {
    MyChirpTheme {
        MyChirpAdaptiveResultLayout(
            modifier = Modifier
                .fillMaxSize(),
            resultContent = {
                Text(
                    text = "Registration successful!",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        )
    }
}
