package com.englishwords.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.englishwords.R

val fontPlayfair = FontFamily(
    Font(R.font.playfair_display_semi_bold, FontWeight.Light),
    Font(R.font.playfair_display_black, FontWeight.Normal),
    Font(R.font.playfair_display_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.playfair_display_black_bold, FontWeight.Bold),
    Font(R.font.playfair_display_black_semi, FontWeight.Medium)
)