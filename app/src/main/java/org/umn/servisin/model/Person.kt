package org.umn.servisin.model

import androidx.annotation.DrawableRes

data class Person(
    @DrawableRes val imageRes: Int?,   // null = tampilkan placeholder
    val name: String,
    val rating: Double,
    val reviewCount: Int,
    val services: List<String>,
    val distance: String
)
