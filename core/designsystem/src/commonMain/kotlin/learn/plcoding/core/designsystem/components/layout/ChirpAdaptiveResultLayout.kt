package learn.plcoding.core.designsystem.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import learn.plcoding.core.designsystem.components.brand.MyChirpBrandLogo
import learn.plcoding.core.designsystem.theme.MyChirpTheme
import learn.plcoding.core.presentation.util.DeviceConfiguration
import learn.plcoding.core.presentation.util.currentDeviceConfiguration
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MyChirpAdaptiveResultLayout(
    modifier: Modifier = Modifier,
    resultContent: @Composable ColumnScope.() -> Unit,
) {
    val deviceConfig : DeviceConfiguration = currentDeviceConfiguration()
    Scaffold(
        modifier = modifier,
    ){ innerPadding ->
        if(deviceConfig == DeviceConfiguration.MOBILE_PORTRAIT) {
            MyChirpSurface (
                modifier = Modifier
                    .padding(innerPadding),
                header = {
                    Spacer(modifier = Modifier.height(32.dp))
                    MyChirpBrandLogo()
                    Spacer(modifier = Modifier.height(32.dp))
                },
                content = resultContent
            )
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                if(deviceConfig != DeviceConfiguration.MOBILE_LANDSCAPE) {
                    MyChirpBrandLogo()
                }
                Column(
                    modifier = Modifier
                        .widthIn(max = 480.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(32.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(horizontal = 24.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    resultContent()
                }
            }
        }

    }
}

@Composable
@Preview
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