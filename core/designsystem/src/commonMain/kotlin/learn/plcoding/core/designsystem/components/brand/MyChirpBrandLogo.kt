package learn.plcoding.core.designsystem.components.brand




import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mychirp.core.designsystem.composeresources.Res
import mychirp.core.designsystem.composeresources.logo
import org.jetbrains.compose.resources.vectorResource

@Composable
fun MyChirpBrandLogo(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = vectorResource(Res.drawable.logo),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary,
        modifier = modifier
    )
}