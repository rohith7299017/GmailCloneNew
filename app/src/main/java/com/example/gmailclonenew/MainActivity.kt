package com.example.gmailclonenew // Fixed: Added 'new' to match namespace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gmailclonenew.ui.GmailCloneApp
import com.example.gmailclonenew.ui.theme.GmailCloneTheme // Fixed import path

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneTheme {
                GmailCloneApp()
            }
        }
    }
}