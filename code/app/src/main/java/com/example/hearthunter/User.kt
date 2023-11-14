package com.example.hearthunter

data class User(
    var id: Int? = null,
    var email: String = "",
    var password: String = "",
    var name: String = "",
    var dateOfBirth: String = "",
    var photoPath: String = "",
    var about: String = "",
    var gender: String = "",
    var city: String = "",
    var confirmed: Boolean = false,
    var available: Boolean = true
)
