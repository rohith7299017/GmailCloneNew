package com.example.gmailclonenew.data

import androidx.compose.runtime.mutableStateListOf
import com.example.gmailclonenew.model.Email

object EmailRepository {

    private val emails = mutableStateListOf(
        Email(
            id = 1,
            fromName = "Alice Johnson",
            fromEmail = "alice@example.com",
            to = "you@example.com",
            subject = "Welcome to GmailClone!",
            preview = "Thanks for trying out this sample Gmail-like app.",
            body = """
                Hi there,

                Thanks for installing the GmailClone sample app. This email is here to show
                how the detail screen looks with a longer message body.

                Feel free to scroll, tap the header to expand details, and explore the UI.

                Best,
                Alice
            """.trimIndent(),
            timestamp = System.currentTimeMillis() - 5 * 60 * 60 * 1000L,
            isRead = false
        ),
        Email(
            id = 2,
            fromName = "Bob Smith",
            fromEmail = "bob@example.com",
            to = "you@example.com",
            subject = "Project meeting notes",
            preview = "Here are the notes from our last meeting...",
            body = """
                Hi,

                As discussed, here are the main takeaways from our last project meeting:

                - Finalize UI for the inbox screen
                - Implement navigation between inbox and detail
                - Polish the theme and colors

                Regards,
                Bob
            """.trimIndent(),
            timestamp = System.currentTimeMillis() - 26 * 60 * 60 * 1000L,
            isRead = true
        ),
        Email(
            id = 3,
            fromName = "Design Updates",
            fromEmail = "design@example.com",
            to = "you@example.com",
            subject = "New Gmail-like color palette",
            preview = "Check out these color suggestions for your clone...",
            body = """
                Hello,

                We've prepared a palette that roughly matches the look and feel of Gmail
                while avoiding exact brand colors. Try using a rich red for the primary,
                neutral surfaces, and subtle dividers for list items.

                Thanks,
                Design Team
            """.trimIndent(),
            timestamp = System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000L,
            isRead = false
        ),
        Email(
            id = 4,
            fromName = "Newsletters",
            fromEmail = "newsletter@example.com",
            to = "you@example.com",
            subject = "Your daily update with a very long subject line that should truncate nicely",
            preview = "Today in your inbox: long subjects, Compose layouts, and more...",
            body = """
                Hi,

                This email exists mainly to demonstrate how long subjects and previews
                are truncated in the inbox list.

                Have a great day!
            """.trimIndent(),
            timestamp = System.currentTimeMillis() - 45 * 60 * 1000L,
            isRead = false
        ),
        Email(
            id = 5,
            fromName = "Support",
            fromEmail = "support@example.com",
            to = "you@example.com",
            subject = "Your ticket has been resolved",
            preview = "We’ve closed your recent support ticket. Let us know if you need anything else.",
            body = """
                Hi,

                Your recent support ticket has been resolved. If the issue comes back
                or you have any questions, just reply to this message.

                Cheers,
                Support Team
            """.trimIndent(),
            timestamp = System.currentTimeMillis() - 90 * 60 * 1000L,
            isRead = true
        )
    )

    fun getEmails(): List<Email> = emails

    fun getEmailById(id: Int): Email? = emails.firstOrNull { it.id == id }

    fun markAsRead(id: Int) {
        val index = emails.indexOfFirst { it.id == id }
        if (index != -1) {
            val current = emails[index]
            if (!current.isRead) {
                emails[index] = current.copy(isRead = true)
            }
        }
    }
}

