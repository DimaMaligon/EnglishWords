package com.englishwords.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 44. sp,
        lineHeight = 28. sp,
        letterSpacing = 0. sp,
        fontFamily = fontPlayfair
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 25. sp,
        lineHeight = 24. sp,
        letterSpacing = 0.15.sp,
        fontFamily = fontPlayfair
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12. sp,
        lineHeight = 20. sp,
        letterSpacing = 0.05.sp,
        fontFamily = fontPlayfair
    ),
)