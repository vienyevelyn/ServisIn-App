package org.umn.servisin.datas

import org.umn.servisin.R
import org.umn.servisin.model.CategoryItem

object ServisDataSource {
    val categoryList = listOf(
        CategoryItem(R.drawable.menu_cleaning, "Cleaning", "cleaning_route"),
        CategoryItem(R.drawable.menu_ac, "AC Service", "ac_route"),
        CategoryItem(R.drawable.menu_electric, "Electrical", "electrical_route"),
        CategoryItem(R.drawable.menu_plumber, "Plumbing", "plumbing_route"),
        CategoryItem(R.drawable.menu_builder, "Renovation", "renovation_route"),
        CategoryItem(R.drawable.menu_electric, "Appliances", "appliances_route")
    )

    val promoVouchers = listOf(
        R.drawable.voucher1,
        R.drawable.voucher2
    )
}