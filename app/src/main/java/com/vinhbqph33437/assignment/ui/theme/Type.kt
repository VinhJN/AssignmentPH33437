package com.vinhbqph33437.assignment.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vinhbqph33437.assignment.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val Merriweather_regular = FontFamily(
    Font(R.font.merriweather_regular, FontWeight.W400),
)

val Merriweather_bold = FontFamily(
    Font(R.font.merriweather_bold, FontWeight.W700),
)

val gelasioFontFamily = FontFamily(
    Font(R.font.gelasio_semibold, FontWeight.Black),
)

val nunitosansFontFamily = FontFamily(
    Font(R.font.nunitosans_10pt_semiexpanded_semibold, FontWeight.Black),
)

val merriweatherFontFamily = FontFamily(
    Font(R.font.merriweather, FontWeight.Black),
)
