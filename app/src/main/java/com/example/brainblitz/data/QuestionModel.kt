package com.example.brainblitz.data

data class Question(
    val question: String,
    val options: List<String>,
    val answer: String,
    val difficulty: String,

)
