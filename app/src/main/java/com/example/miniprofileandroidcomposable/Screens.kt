package com.example.miniprofileandroidcomposable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Styles in here
val infoBoxModifier = Modifier
    .background(Color.Yellow)
    .padding(3.dp)

val spacerSmallVerticalModifier = Modifier
    .height(10.dp)

val QnAStyle = TextStyle(
    fontSize = (24.sp),
    color = Color.Green
)


// Profile Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Profile Details", style = textInformationStyle)
            Spacer(modifier = spacerNormalVerticalModifier)
            Text("This is where profile information would go")
        }
    }
}

// Personal Information Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInformationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Personal Information") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Row(modifier = spaceFillerWidthModifier,horizontalArrangement = Arrangement.SpaceBetween){
                Text("Name:", style = textInformationStyle)
                Box(modifier = infoBoxModifier){
                    Text("Jeff Rouzel Bat-og", style = textInformationStyle)
                }
            }

            Spacer(modifier = spacerSmallVerticalModifier)
            Row(modifier = spaceFillerWidthModifier,horizontalArrangement = Arrangement.SpaceBetween){
                Text("Email:", style = textInformationStyle)
                Box(modifier = infoBoxModifier){
                    Text("jbatog2@77global.biz", style = textInformationStyle)
                }
            }
            Spacer(modifier = spacerSmallVerticalModifier)
            // Phone Number
            Row(modifier = spaceFillerWidthModifier,horizontalArrangement = Arrangement.SpaceBetween){
                Text("Phone:", style = textInformationStyle)
                Box(modifier = infoBoxModifier){
                    Text("+63 929 258 7564", style = textInformationStyle)
                }
            }

        }
    }
}

// Notification Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notification Settings") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Notification preferences", style = textLabelStyle)
            Box(contentAlignment = Alignment.CenterStart){
                Card(modifier = Modifier
                    .padding(36.dp),
                    elevation = CardDefaults.cardElevation(5.dp))
                { Text("Yung malambing ganon", style = textInformationStyle,
                    modifier = Modifier
                        .padding(16.dp)
                ) }
            }
        }
    }
}

// Time Spent Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeSpentScreen(navController: NavController) {
    var count by remember { mutableStateOf(0) }
        Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Time Spent") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp,),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Your activity time statistics", style = textInformationStyle)
            Card(modifier = Modifier
                .padding(36.dp),
                elevation = CardDefaults.cardElevation(5.dp))
            { Text(text = "Time: $count seconds",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = { count++ }),
                style = userNameStyle
            ) }
        }
    }
}

// Following Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FollowingScreen(navController: NavController) {
    var count by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Following") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp,),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("People you follow", style = textInformationStyle)
            Card(modifier = Modifier
                .padding(36.dp),
                elevation = CardDefaults.cardElevation(5.dp))
            { Text(text = "Count: $count users",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = { count++ }),
                style = userNameStyle
            ) }
        }
    }
}

// Privacy Policy Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy Policy") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Green),
                contentAlignment = Alignment.Center
            ){
                Text("Quite open bruv", style = textInformationStyle)
            }
        }
    }
}

// Terms and Conditions Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Terms and Conditions") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Lorem", style = textInformationStyle)
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
            Spacer(modifier = spacerNormalVerticalModifier)
            Text("Ipsum", style = textInformationStyle)
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
        }
    }
}


data class QnA(val question: String, val answer: String)

val questionAndAnswer = listOf(
    QnA("Pogi ka ba?", "Of course, Yes"),
    QnA("Single?", "Ready to mingle!"),
)
// FAQ Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FAQ and Help") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Frequently Asked Questions", style = textInformationStyle)
            Spacer(modifier = spacerNormalVerticalModifier)

            LazyColumn{
                items(questionAndAnswer){ questionAndAnswer ->
                    Row{
                        Spacer(modifier = spacerNormalVerticalModifier)
                        Row{
                            Text(text = questionAndAnswer.question,
                                modifier = textInformationModifier,
                                style = textInformationStyle)
                            Text(text = questionAndAnswer.answer,
                                modifier = textInformationModifier,
                                style = QnAStyle)
                        }
                    }
                }
            }

        }
    }
}