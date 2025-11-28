package learn.plcoding.core.designsystem.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import learn.plcoding.core.designsystem.components.brand.MyChirpSuccessIcon
import learn.plcoding.core.designsystem.components.buttons.MyChirpButton
import learn.plcoding.core.designsystem.components.buttons.MyChirpButtonStyle
import learn.plcoding.core.designsystem.theme.MyChirpTheme
import learn.plcoding.core.designsystem.theme.extended
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MyChirpSimpleSuccessLayout(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    icon: @Composable () -> Unit,
    primaryButton: @Composable () -> Unit,
    secondaryButton: @Composable (() -> Unit)? = null,
    ) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        icon()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = -(25).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.extended.textPrimary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.extended.textSecondary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))
            primaryButton()
            if(secondaryButton != null) {
                Spacer(modifier = Modifier.height(8.dp))
                secondaryButton()
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}

@Composable
@Preview(
//    showBackground = true
)
fun MyChirpSimpleSuccessLayoutPreview() {
    MyChirpTheme {
        MyChirpSimpleSuccessLayout(
            title = "success-text-placeHolder successful!",
            description = "description-placeHolder successful!",
            icon = {
               MyChirpSuccessIcon()
            },
            primaryButton = {
                MyChirpButton(
                    text = "Log in",
                    onClick = {},
                    Modifier.fillMaxWidth()
                )
            },
            secondaryButton = {
                MyChirpButton(
                    text = "resend verification",
                    onClick = {},
                    Modifier.fillMaxWidth(),
                    style = MyChirpButtonStyle.SECONDARY
                )
            }
        )
    }
}
