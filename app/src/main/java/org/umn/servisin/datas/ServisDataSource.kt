package org.umn.servisin.datas

import org.umn.servisin.R
import org.umn.servisin.model.CategoryItem
import org.umn.servisin.model.Review
import org.umn.servisin.model.ServisCategory
import org.umn.servisin.model.Worker

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

    val workers = listOf(
        Worker(
            name = "Andi Pratama",
            payPerHour = 50000,
            description = "Experienced plumber specializing in pipe repairs and water installations.",
            rating = 4.8,
            reviews = listOf(
                Review("Sarah", "Fixed my leaking pipe quickly!", 5),
                Review("Budi", "Friendly and professional service.", 5)
            ),
            keahlian = listOf(
                "Plumbing",
                "Pipe Repair",
                "Water Installation"
            ),
            picture = R.drawable.cleaner1,
            experience = 5
        ),
        Worker(
            name = "Siti Rahma",
            payPerHour = 45000,
            description = "Professional house cleaner who specializes in deep cleaning and organizing.",
            rating = 4.7,
            reviews = listOf(
                Review("Diana", "My house looks spotless!", 5),
                Review("Rina", "Very thorough and punctual.", 3)
            ),
            keahlian = listOf(
                "House Cleaning",
                "Deep Cleaning",
                "Home Organization"
            ),
            picture = R.drawable.cleaner1,
            experience = 3
        ),
        Worker(
            name = "Budi Santoso",
            payPerHour = 60000,
            description = "Skilled electrician experienced in home wiring and electrical repairs.",
            rating = 4.9,
            reviews = listOf(
                Review("Andi", "Solved my electrical problem perfectly.", 5),
                Review("Maya", "Quick, safe, and reliable.", 4)
            ),
            keahlian = listOf(
                "Electrical Repair",
                "Home Wiring",
                "Lighting Installation"
            ),
            picture = R.drawable.cleaner1,
            experience = 8
        )
    )
}