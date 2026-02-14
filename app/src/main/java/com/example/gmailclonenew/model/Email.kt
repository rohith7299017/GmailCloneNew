package com.example.gmailclonenew.model

data class Email(
    val id: Int,
    val fromName: String,
    val fromEmail: String,
    val to: String,
    val subject: String,
    val preview: String,
    val body: String,
    val timestamp: Long,
    val isRead: Boolean
)
