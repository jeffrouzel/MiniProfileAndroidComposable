package com.example.miniprofileandroidcomposable

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miniprofileandroidcomposable.ui.theme.MiniProfileAndroidComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Header()
        }
    }
}

data class AS(val name: String)
data class HAS(val name: String)

val accountSettings = listOf(
    AS("Personal Information"),
    AS("Notification"),
    AS("Time Spent"),
    AS("Following")
)
val helpAndSupport = listOf(
    HAS("Privacy Policy"),
    HAS("Terms and Conditions"),
    HAS("FAQ and Help")
)

// Modifiers
val textInformationModifier = Modifier
    .padding(
        horizontal = dimensionResource(id = R.dimen.small_space),
        vertical = dimensionResource(id = R.dimen.small_space)
    )

val textInformationStyle = TextStyle(
    fontSize = dimensionResource(id = R.dimen.medium_text),
    color = Color.Black
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(){
    Scaffold (
        topBar ={
            TopAppBar(title= {Text("Mini Profile Android")})
        }
    ) {
        LazyColumn (modifier = Modifier.padding(15.dp, 75.dp, 15.dp, 15.dp )) {
            //
            item{ UserDetails() }
            // Account Settings
            item{Text("Account Settings")}
            items(accountSettings){ accountSettings ->
                Text(text = accountSettings.name,
                modifier = textInformationModifier,
                style = textInformationStyle)

            }
            // Help and Support Settings
            item{Text("Help and Support")}
            items(helpAndSupport){ helpAndSupport ->
                Text(text = helpAndSupport.name,
                    modifier = textInformationModifier,
                    style = textInformationStyle)

            }
            // Log Out Button
            item{Button(onClick = { /*TODO*/ }) {
                Text(text = "Logout")
            }}
        }
    }
}

@Composable
fun UserDetails(){
    Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = stringResource(id = R.string.user_icon),
            modifier = Modifier
                .size(150.dp) // Set a specific size
                .clip(CircleShape), // This makes it round
            contentScale = ContentScale.Crop // Important: Crops the image to fill the circle
        )
        Text(text = "Jeff Rouzel Bat-og")
        Text(text = "jbatog2@77global.biz")
        Text(text = "Check out my Profile!")
    }
}
