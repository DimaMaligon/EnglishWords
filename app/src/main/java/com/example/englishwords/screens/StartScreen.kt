package com.example.englishwords.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.englishwords.R
import com.example.englishwords.navigation.LETTER_ROUTE
import com.example.englishwords.navigation.Screens
import com.example.englishwords.ui.theme.fontPlayfair

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    navController: NavHostController
) {
    var openDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        Modifier.padding(start = 40.dp),
                        fontFamily = fontPlayfair,
                        fontWeight = FontWeight.Normal
                    )
                },
                actions = {
                    IconButton(onClick = {
                        openDialog = !openDialog
                    }) {
                        Icon(Icons.Filled.Info, stringResource(id = R.string.title_icon_info))
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
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    PopupWindowDialog(
                        openDialog = openDialog,
                        stringResource(id = R.string.text_ifo_about_app)
                    )
                }
                Column() {
                    Button(
                        onClick = {
                            navController.navigate(route = LETTER_ROUTE)
                        },
                        Modifier
                            .padding(top = 170.dp).height(180.dp).width(280.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("Словарь", fontSize = 26.sp)
                    }
                }
                Column() {
                    Button(
                        onClick = {
                            navController.navigate(route = Screens.RepeatWords.route)
                        },
                        Modifier
                            .padding(top = 10.dp).height(180.dp).width(280.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("Упражнения", fontSize = 26.sp)
                    }
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    )
}
