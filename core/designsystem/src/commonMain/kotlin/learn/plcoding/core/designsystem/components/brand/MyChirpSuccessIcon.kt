package learn.plcoding.core.designsystem.components.brand

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import learn.plcoding.core.designsystem.theme.extended
import mychirp.core.designsystem.composeresources.Res
import mychirp.core.designsystem.composeresources.success_checkmark
import org.jetbrains.compose.resources.vectorResource

@Composable
fun MyChirpSuccessIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = vectorResource(Res.drawable.success_checkmark),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.extended.success,
        modifier = modifier
    )
}