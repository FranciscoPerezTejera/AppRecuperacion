package com.example.apprecuperacionfranciscopereztejera.model

data class User(
    val id: Int,
    val email: String,
    val password: String,
    val vehicles: List<Vehicle>?
)
