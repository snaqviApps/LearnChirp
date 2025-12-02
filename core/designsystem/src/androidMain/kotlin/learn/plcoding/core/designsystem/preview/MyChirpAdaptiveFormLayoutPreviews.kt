package learn.plcoding.core.designsystem.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import learn.plcoding.core.designsystem.components.brand.MyChirpBrandLogo
import learn.plcoding.core.designsystem.theme.MyChirpTheme
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.core.designsystem.components.layouts.MyChirpAdaptiveFormLayout

@Composable
@Preview
@PreviewLightDark
@PreviewScreenSizes

fun MyChirpAdaptiveFormLayoutLightPreview() {
    MyChirpTheme {
        MyChirpAdaptiveFormLayout(
            headerText = "Welcome to Chirp!",
            errorText = "Login failed",
            logo = { MyChirpBrandLogo() },
            formContent = {
                Text(
                    text = "Sample form title",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Sample form title 2",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

        )
    }
}

