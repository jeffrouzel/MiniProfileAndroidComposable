package com.example.miniprofileandroidcomposable

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

// I learned that this is the newer way for navigation in compose rather than the use of fragments
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { MiniProfileSettings(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("personal_info") { PersonalInformationScreen(navController) }
        composable("notification") { NotificationScreen(navController) }
        composable("time_spent") { TimeSpentScreen(navController) }
        composable("following") { FollowingScreen(navController) }
        composable("privacy") { PrivacyPolicyScreen(navController) }
        composable("terms") { TermsScreen(navController) }
        composable("faq") { FAQScreen(navController) }
    }
}

///////////////////////////////////////////////////////////////
// EDITS
data class AS(val name: String, val route: String)
data class HAS(val name: String, val route: String)

val accountSettings = listOf(
    AS("Personal Information", "personal_info"),
    AS("Notification", "notification"),
    AS("Time Spent", "time_spent"),
    AS("Following", "following")
)
val helpAndSupport = listOf(
    HAS("Privacy Policy", "privacy"),
    HAS("Terms and Conditions", "terms"),
    HAS("FAQ and Help", "faq")
)
///////////////////////////////////////////////////////////////
// Styling
// TEXT Styling
val textInformationModifier = Modifier
    .padding(
        horizontal = (8.dp),
        vertical = (8.dp)
    )
val textInformationStyle = TextStyle(
    fontSize = (24.sp),
    color = Color.Black
)
val textLabelStyle = TextStyle(
    fontSize = (16.sp),
    color = Color.Gray
)


// USER Styles
val userNameStyle = TextStyle(
    fontSize = (32.sp),
    color = Color.Black
)
val userImageModifier = Modifier
    .size(150.dp) // Set a specific size
    .clip(CircleShape)


// Spacers
val spacerNormalVerticalModifier = Modifier
    .height(20.dp)
val spacerSmallHorizontalModifier = Modifier
    .width(10.dp)
val spaceFillerWidthModifier = Modifier
    .fillMaxWidth()
val spaceFillerHeightModifier = Modifier
    .fillMaxWidth()


// Button Styles
val openInfoButtonModifier = Modifier
    .size(36.dp)

///////////////////////////////////////////////////////////////
// Composables
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiniProfileSettings(navController: NavController){
    Scaffold (
        topBar ={
            TopAppBar(title= {Text("Mini Profile Android")})
        }
    ) {
        LazyColumn (modifier = Modifier.padding(15.dp, 75.dp, 15.dp, 15.dp )) {
            //
            item{ UserDetails(navController) }
            // Account Settings
            item{Spacer(modifier = spacerNormalVerticalModifier)}
            item{Text("Account Settings" , style = textLabelStyle)}
            items(accountSettings){ accountSettings ->
                InfoSettings(accountSettings.name, navController, accountSettings.route)
            }
            // Help and Support Settings
            item{Spacer(modifier = spacerNormalVerticalModifier)}
            item{Text("Help and Support", style = textLabelStyle)}
            items(helpAndSupport){ helpAndSupport ->
                InfoSettings(helpAndSupport.name, navController, helpAndSupport.route)
            }
            // Log Out Button
            item{Spacer(modifier = spacerNormalVerticalModifier)}
            item{Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White // or whatever color you want for the icon
            )) {
                Text(text = "Logout")
            }}
        }
    }
}

@Composable
fun UserDetails(navController: NavController){
    Column (modifier = spaceFillerHeightModifier,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = stringResource(id = R.string.user_icon),
            modifier = userImageModifier, // This makes it round
            contentScale = ContentScale.Crop // Important: Crops the image to fill the circle
        )
        Text(text = "Jeff Rouzel Bat-og", style = userNameStyle)
        Text(text = "jbatog2@77global.biz", style = textLabelStyle)
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "View Profile")
        }
    }
}

@Composable
fun InfoSettings(textlbl: String, navController: NavController, route: String){
    Row{
        Spacer(modifier = spacerSmallHorizontalModifier)
        Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = spaceFillerWidthModifier){
            Text(text = textlbl,
                modifier = textInformationModifier,
                style = textInformationStyle)
            Button(onClick = { navController.navigate(route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black // or whatever color you want for the icon
                )
            ) {Icon(painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = stringResource(id = R.string.arrowRight_desc),
                modifier = openInfoButtonModifier
            )
            }
        }
    }
}