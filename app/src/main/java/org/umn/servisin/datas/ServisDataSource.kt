package org.umn.servisin.datas

import org.umn.servisin.R
import org.umn.servisin.model.CategoryItem
import org.umn.servisin.model.Person
import org.umn.servisin.model.ServisCategory

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

    val serviceItems = listOf(
        ServisCategory(
            imageRes = R.drawable.cat_ac,
            title = "AC & Cooling",
            description = "Cuci AC, Isi Freon, Bongkar Pasang AC, Perbaikan AC Tidak Dingin/Bocor.",
            categoryRoute = "ac_route"
        ),
        ServisCategory(
            imageRes = R.drawable.cat_home,
            title = "Home Electronic",
            description = "Perbaikan Kulkas, Mesin Cuci, TV, Microwave, Dispenser, dan Kompor Gas.",
            categoryRoute = "appliances_route"
        ),
        ServisCategory(
            imageRes = R.drawable.cat_plumber,
            title = "Plumbing & Sanitation",
            description = "Perbaikan Pipa Bocor, Saluran Mampet, Sedot WC, Pemasangan Pompa Air, dan Water Heater.",
            categoryRoute = "plumbing_route"
        ),
        ServisCategory(
            imageRes = R.drawable.cat_electric,
            title = "Electrician",
            description = "Perbaikan Korsleting, Pemasangan Sakelar/Stopkontak, Instalasi Lampu, dan Panel Listrik.",
            categoryRoute = "electrical_route"
        ),
        ServisCategory(
            imageRes = R.drawable.cat_builder,
            title = "Builder & Constructor",
            description = "Perbaikan Atap/Bocor, Cat Dinding, Perbaikan Pintu/Jendela, Tukang Kayu, dan Keramik.",
            categoryRoute = "renovation_route"
        ),
        ServisCategory(
            imageRes = R.drawable.cat_cleaner,
            title = "Cleaning & Pest Control",
            description = "Deep Cleaning Rumah, Cuci Kasur/Sofa/Karpet, Pembasmi Rayap/Serangga, dan Disinfeksi.",
            categoryRoute = "cleaning_route"
        )
    )

    val peopleList = listOf(
        Person(
            imageRes = null,
            name = "Siti Rohani",
            rating = 4.9,
            reviewCount = 120,
            services = listOf("Membersihkan karat", "Kaca", "Lantai", "Area toilet", "Disinfeksi", "Detailing dapur"),
            distance = "1.2 km away"
        ),
        Person(
            imageRes = null,
            name = "Budi Santoso",
            rating = 4.5,
            reviewCount = 120,
            services = listOf("Membersihkan karat", "Kaca", "Lantai", "Area toilet", "Disinfeksi", "Detailing dapur"),
            distance = "1.2 km away"
        ),
        Person(
            imageRes = null,
            name = "Dewi Lestari",
            rating = 4.5,
            reviewCount = 120,
            services = listOf("Membersihkan karat", "Kaca", "Lantai", "Area toilet", "Disinfeksi", "Detailing dapur"),
            distance = "1.2 km away"
        )
    )
}
