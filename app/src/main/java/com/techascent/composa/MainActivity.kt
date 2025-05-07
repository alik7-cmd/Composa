package com.techascent.composa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techascent.composa.avatar.Avatar
import com.techascent.composa.avatar.AvatarDefaults
import com.techascent.composa.card.ComposaCardFrame
import com.techascent.composa.ui.theme.ComposaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    ComposaCardFrame(
        borderColor = Color.Gray,
        content = {
            Avatar(
                initial = 'A',
                avatarProperties = AvatarDefaults.small
            )
            Avatar(
                initial = 'A',
                avatarProperties = AvatarDefaults.large
            )
            Avatar(
                initial = 'A',
                avatarProperties = AvatarDefaults.medium
            )

            Avatar(
                initial = 'A',
                avatarProperties = AvatarDefaults.medium
            )
        },
        modifier = Modifier.padding(vertical = 40.dp, horizontal = 20.dp),
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposaTheme {
        Greeting("Android")
    }
}