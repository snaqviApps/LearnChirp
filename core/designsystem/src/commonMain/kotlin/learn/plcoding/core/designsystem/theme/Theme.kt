package learn.plcoding.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }

val ColorScheme.extended: ExtendedColors
    @ReadOnlyComposable
    @Composable
    get() = LocalExtendedColors.current

@Immutable
data class ExtendedColors(
    // Button states
    val primaryHover: Color,
    val destructiveHover: Color,
    val destructiveSecondaryOutline: Color,
    val disabledOutline: Color,
    val disabledFill: Color,
    val successOutline: Color,
    val success: Color,
    val onSuccess: Color,
    val secondaryFill: Color,

    // Text variants
    val textPrimary: Color,
    val textTertiary: Color,
    val textSecondary: Color,
    val textPlaceholder: Color,
    val textDisabled: Color,

    // Surface variants
    val surfaceLower: Color,
    val surfaceHigher: Color,
    val surfaceOutline: Color,
    val overlay: Color,

    // Accent colors
    val accentBlue: Color,
    val accentPurple: Color,
    val accentViolet: Color,
    val accentPink: Color,
    val accentOrange: Color,
    val accentYellow: Color,
    val accentGreen: Color,
    val accentTeal: Color,
    val accentLightBlue: Color,
    val accentGrey: Color,

    // Cake colors for chat bubbles
    val cakeViolet: Color,
    val cakeGreen: Color,
    val cakeBlue: Color,
    val cakePink: Color,
    val cakeOrange: Color,
    val cakeYellow: Color,
    val cakeTeal: Color,
    val cakePurple: Color,
    val cakeRed: Color,
    val cakeMint: Color,
)

val LightExtendedColors = ExtendedColors(
    primaryHover = MyChirpBrand600,
    destructiveHover = MyChirpRed600,
    destructiveSecondaryOutline = MyChirpRed200,
    disabledOutline = MyChirpBase200,
    disabledFill = MyChirpBase150,
    successOutline = MyChirpBrand100,
    success = MyChirpBrand600,
    onSuccess = MyChirpBase0,
    secondaryFill = MyChirpBase100,

    textPrimary = MyChirpBase1000,
    textTertiary = MyChirpBase800,
    textSecondary = MyChirpBase900,
    textPlaceholder = MyChirpBase700,
    textDisabled = MyChirpBase400,

    surfaceLower = MyChirpBase100,
    surfaceHigher = MyChirpBase100,
    surfaceOutline = MyChirpBase1000Alpha14,
    overlay = MyChirpBase1000Alpha80,

    accentBlue = MyChirpBlue,
    accentPurple = MyChirpPurple,
    accentViolet = MyChirpViolet,
    accentPink = MyChirpPink,
    accentOrange = MyChirpOrange,
    accentYellow = MyChirpYellow,
    accentGreen = MyChirpGreen,
    accentTeal = MyChirpTeal,
    accentLightBlue = MyChirpLightBlue,
    accentGrey = MyChirpGrey,

    cakeViolet = MyChirpCakeLightViolet,
    cakeGreen = MyChirpCakeLightGreen,
    cakeBlue = MyChirpCakeLightBlue,
    cakePink = MyChirpCakeLightPink,
    cakeOrange = MyChirpCakeLightOrange,
    cakeYellow = MyChirpCakeLightYellow,
    cakeTeal = MyChirpCakeLightTeal,
    cakePurple = MyChirpCakeLightPurple,
    cakeRed = MyChirpCakeLightRed,
    cakeMint = MyChirpCakeLightMint,
)

val DarkExtendedColors = ExtendedColors(
    primaryHover = MyChirpBrand600,
    destructiveHover = MyChirpRed600,
    destructiveSecondaryOutline = MyChirpRed200,
    disabledOutline = MyChirpBase900,
    disabledFill = MyChirpBase1000,
    successOutline = MyChirpBrand500Alpha40,
    success = MyChirpBrand500,
    onSuccess = MyChirpBase1000,
    secondaryFill = MyChirpBase900,

    textPrimary = MyChirpBase0,
    textTertiary = MyChirpBase200,
    textSecondary = MyChirpBase150,
    textPlaceholder = MyChirpBase400,
    textDisabled = MyChirpBase500,

    surfaceLower = MyChirpBase1000,
    surfaceHigher = MyChirpBase900,
    surfaceOutline = MyChirpBase100Alpha10Alt,
    overlay = MyChirpBase1000Alpha80,

    accentBlue = MyChirpBlue,
    accentPurple = MyChirpPurple,
    accentViolet = MyChirpViolet,
    accentPink = MyChirpPink,
    accentOrange = MyChirpOrange,
    accentYellow = MyChirpYellow,
    accentGreen = MyChirpGreen,
    accentTeal = MyChirpTeal,
    accentLightBlue = MyChirpLightBlue,
    accentGrey = MyChirpGrey,

    cakeViolet = MyChirpCakeDarkViolet,
    cakeGreen = MyChirpCakeDarkGreen,
    cakeBlue = MyChirpCakeDarkBlue,
    cakePink = MyChirpCakeDarkPink,
    cakeOrange = MyChirpCakeDarkOrange,
    cakeYellow = MyChirpCakeDarkYellow,
    cakeTeal = MyChirpCakeDarkTeal,
    cakePurple = MyChirpCakeDarkPurple,
    cakeRed = MyChirpCakeDarkRed,
    cakeMint = MyChirpCakeDarkMint,
)

val LightColorScheme = lightColorScheme(
    primary = MyChirpBrand500,
    onPrimary = MyChirpBrand1000,
    primaryContainer = MyChirpBrand100,
    onPrimaryContainer = MyChirpBrand900,

    secondary = MyChirpBase700,
    onSecondary = MyChirpBase0,
    secondaryContainer = MyChirpBase100,
    onSecondaryContainer = MyChirpBase900,

    tertiary = MyChirpBrand900,
    onTertiary = MyChirpBase0,
    tertiaryContainer = MyChirpBrand100,
    onTertiaryContainer = MyChirpBrand1000,

    error = MyChirpRed500,
    onError = MyChirpBase0,
    errorContainer = MyChirpRed200,
    onErrorContainer = MyChirpRed600,

    background = MyChirpBrand1000,
    onBackground = MyChirpBase0,
    surface = MyChirpBase0,
    onSurface = MyChirpBase1000,
    surfaceVariant = MyChirpBase100,
    onSurfaceVariant = MyChirpBase900,

    outline = MyChirpBase1000Alpha8,
    outlineVariant = MyChirpBase200,
)

val DarkColorScheme = darkColorScheme(
    primary = MyChirpBrand500,
    onPrimary = MyChirpBrand1000,
    primaryContainer = MyChirpBrand900,
    onPrimaryContainer = MyChirpBrand500,

    secondary = MyChirpBase400,
    onSecondary = MyChirpBase1000,
    secondaryContainer = MyChirpBase900,
    onSecondaryContainer = MyChirpBase150,

    tertiary = MyChirpBrand500,
    onTertiary = MyChirpBase1000,
    tertiaryContainer = MyChirpBrand900,
    onTertiaryContainer = MyChirpBrand500,

    error = MyChirpRed500,
    onError = MyChirpBase0,
    errorContainer = MyChirpRed600,
    onErrorContainer = MyChirpRed200,

    background = MyChirpBase1000,
    onBackground = MyChirpBase0,
    surface = MyChirpBase950,
    onSurface = MyChirpBase0,
    surfaceVariant = MyChirpBase900,
    onSurfaceVariant = MyChirpBase150,

    outline = MyChirpBase100Alpha10,
    outlineVariant = MyChirpBase800,
)