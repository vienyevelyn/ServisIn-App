package org.umn.servisin.model

import androidx.annotation.DrawableRes

data class CategoryItem(
    @DrawableRes val iconRes: Int,
    val title: String,
    val route: String
)

