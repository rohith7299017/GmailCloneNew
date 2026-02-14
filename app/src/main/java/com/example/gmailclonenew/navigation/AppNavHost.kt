package com.example.gmailclonenew.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gmailclonenew.data.EmailRepository
import com.example.gmailclonenew.ui.detail.EmailDetailScreen
import com.example.gmailclonenew.ui.inbox.InboxScreen

object Routes {
    const val INBOX = "inbox"
    const val EMAIL_DETAIL = "email/{emailId}"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.INBOX
    ) {
        composable(Routes.INBOX) {
            InboxScreen(
                emails = EmailRepository.getEmails(),
                onEmailClick = { emailId ->
                    navController.navigate("email/$emailId")
                }
            )
        }

        composable(
            route = Routes.EMAIL_DETAIL,
            arguments = listOf(
                navArgument("emailId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val emailId = backStackEntry.arguments?.getInt("emailId") ?: return@composable
            val email = EmailRepository.getEmailById(emailId)

            if (email != null) {
                EmailDetailScreen(
                    email = email,
                    onBack = { navController.popBackStack() }
                )
            } else {
                // If email is not found, just go back.
                navController.popBackStack()
            }
        }
    }
}

