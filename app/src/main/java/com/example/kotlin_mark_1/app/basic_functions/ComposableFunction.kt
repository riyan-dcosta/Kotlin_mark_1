package com.example.kotlin_mark_1.app.basic_functions

import android.content.res.Configuration
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_mark_1.R
import com.example.kotlin_mark_1.ui.theme.Kotlin_mark_1Theme

@Composable
fun HomePage() {
    var showOnBoarding by rememberSaveable { mutableStateOf(true) }
    Kotlin_mark_1Theme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            if (showOnBoarding) {
                OnBoarding {
                    showOnBoarding = !showOnBoarding
                }
            } else {
                ProfilePage()
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 360)
@Composable
fun ProfilePage() {
    Column(modifier = Modifier.fillMaxWidth()) {
        ProfileCard()
        RadioButtonComp(buttonName = "Dark Mode", buttonState = false)
        ExpandCardButton(text = "Info", buttonText = "Expand")
    }
}

@Composable
fun ExpandCardButton(text: String, buttonText: String) {
    var expanded: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    val cardHeight by animateDpAsState(
        targetValue = if (expanded) 48.dp else 0.dp, label = "",
    )
    Surface(color = Color.Blue) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = text, modifier = Modifier
                    .weight(1f)
                    .padding(bottom = cardHeight)
            )
            IconButton(onClick = {
                expanded != expanded
            }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled
                        .KeyboardArrowUp,
                    contentDescription = if (expanded) {
                        stringResource(id = R.string.show_less)
                    } else {
                        stringResource(id = R.string.show_more)
                    }
                )
            }
//            ElevatedButton(onClick = {
//                expanded = !expanded
//            }) {
//                Text(text = buttonText)
//            }
        }
    }
}

@Composable
fun OnBoarding(onContinueClicked: () -> Unit) {
    Column {
        Text(text = "Welcome HEre")
        Button(onClick = onContinueClicked) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun ProfileCard() {
    Row(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "profile_photo",
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
        )
        Greeting("Riyan")
    }
}

@Composable
fun RadioButtonComp(buttonName: String, buttonState: Boolean) {
    Row(
        modifier = Modifier.border(border = BorderStroke(width = 1.dp, color = Color.Black)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = buttonName)
        var buttonSelected: MutableState<Boolean> = rememberSaveable { mutableStateOf(buttonState) }
        RadioButton(buttonSelected.value, onClick = {
            buttonSelected.value = !buttonSelected.value
        })
    }
}

@Composable
fun Greeting(name: String = "empty") {
    Text(
        text = "Hello $name",
        style = MaterialTheme.typography.labelMedium,
//        modifier = Modifier.padding(8.dp),
//        textAlign = TextAlign.Center
    )
}

@Preview(name = "Light-Mode")
@Preview(
    name = "Dark-Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun GreetingPreview() {
    Kotlin_mark_1Theme {
        HomePage()
    }
}

