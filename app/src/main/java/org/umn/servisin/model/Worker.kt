package org.umn.servisin.model

data class Worker(
    val name: String,
    val payPerHour: Int,
    val description: String,
    val rating: Double,
    val reviews: List<Review> = emptyList(),
    val keahlian: List<String> = emptyList(),
    val picture: Int,
    val experience: Int
)

