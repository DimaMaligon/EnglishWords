package com.englishwords.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.englishwords.LocalNavController
import com.englishwords.R
import com.englishwords.ui.theme.fontPlayfair

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorScreen() {
    val navController = LocalNavController.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name),
                        Modifier.padding(start = 10.dp),
                        fontFamily = fontPlayfair,
                        fontWeight = FontWeight.Normal)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, stringResource(id = R.string.title_icon_back))
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                )
            )
        },
        content = { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(100.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.title_screen_error),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    color = Color.Red,
                    fontFamily = fontPlayfair,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    )
}